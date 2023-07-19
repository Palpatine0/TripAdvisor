package com.example.tripadvisor.service;

import com.example.tripadvisor.pojo.Comments;
import com.example.tripadvisor.mapper.CommentsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsService {
    @Autowired
    private CommentsMapper CommentsMapper;

    public void add(Comments Comments) {
        CommentsMapper.insert(Comments);
    }

    public void update(Comments Comments) {
        CommentsMapper.updateById(Comments);
    }

    public Comments findById(Integer cid) {
        return CommentsMapper.selectById(cid);
    }

    public List<Comments> findByPid(Integer pid) {
        return CommentsMapper.findByPid(pid);
    }

    public void delete(Comments cid) {
        CommentsMapper.deleteById(cid);
    }


}
