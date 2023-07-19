package com.example.tripadvisor.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.tripadvisor.bean.Result;
import com.example.tripadvisor.mapper.MemberMapper;
import com.example.tripadvisor.mapper.ProductMapper;
import com.example.tripadvisor.pojo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private BCryptPasswordEncoder encoder;
    @Value(("${project.path}"))
    private String projectPath;


    public Page<Member> findPage(int page, int size){
        Page selectPage = memberMapper.selectPage(new Page(page,size),null);
        return selectPage;
    }


    public Result register(Member member) {
        // 1. Save user
        // 1.1 Check if the name repeat
        QueryWrapper<Member> queryWrapperUN = new QueryWrapper<>();
        queryWrapperUN.eq("username", member.getUsername());
        List<Member> memberUN = memberMapper.selectList(queryWrapperUN);
        if (memberUN.size() > 0) {
            return new Result(false, "Existed username");
        }
        // 1.2 Check if the cell repeat
        QueryWrapper<Member> queryWrapperC = new QueryWrapper<>();
        queryWrapperC.eq("phoneNum", member.getPhoneNum());
        List<Member> memberC = memberMapper.selectList(queryWrapperC);
        if (memberC.size() > 0) {
            return new Result(false, "Existed cell combination");
        }
        // 1.3 Check if the email repeat
        QueryWrapper<Member> queryWrapperM = new QueryWrapper<>();
        queryWrapperM.eq("email", member.getEmail());
        List<Member> memberM = memberMapper.selectList(queryWrapperM);
        if (memberM.size() > 0) {
            return new Result(false, "Existed Email");
        }
        // 1.4 Encode password and save user
        String password = member.getPassword();
        password = encoder.encode(password);
        member.setPassword(password);

        memberMapper.insert(member);

        return new Result(true, "Sign up done");
    }



    //sign in
    public Result login(String username,String password){
        Member member = null;

        //check if exist
        if (member == null){
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("username",username);
            member=memberMapper.selectOne(queryWrapper);
        }
        if (member == null){
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("email",username);
            member=memberMapper.selectOne(queryWrapper);
        }
        if (member == null){
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("phoneNum",username);
            member=memberMapper.selectOne(queryWrapper);
        }
        if (member == null){
           return new Result(false,"Account doesn't exist");
        }
        boolean flag = encoder.matches(password, member.getPassword());
        if (!flag){
            return new Result(false,"Password Incorrect");
        }

        return new Result(true,"Successful login",member);
    }

    public Member findById(Integer id) {
        return memberMapper.selectById(id);
    }

    public void update(Member member){
        memberMapper.updateById(member);
    }

    public void incrementScoreByMemberId(Member member, int increment) {
        Integer cScore = memberMapper.selectById(member.getMid()).getScore();
        if (member != null) {
            int newScore = cScore + increment;
            member.setScore(newScore);
            memberMapper.updateById(member);
        }
    }

    public int getSubmissionCountByMemberAndDate(Member member, LocalDate date) {
        return productMapper.getSubmissionCountByMemberAndDate(member.getMid(), date);
    }



}
