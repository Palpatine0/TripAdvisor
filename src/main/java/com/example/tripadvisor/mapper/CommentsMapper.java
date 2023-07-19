package com.example.tripadvisor.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.tripadvisor.pojo.Comments;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentsMapper extends BaseMapper<Comments> {
    List<Comments> findByPid(@Param("pid") Integer pid);
}
