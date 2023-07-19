package com.example.tripadvisor.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.example.tripadvisor.pojo.Member;
import com.example.tripadvisor.pojo.Product;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class Comments {
    @TableId
    private Integer cid;
    private Integer pid;
    private Integer mid;
    private String remoteAddr;
    private String commentText;
    private Timestamp createdAt;


    @TableField(exist = false)
    private Product product;

    @TableField(exist = false)
    private Member member;

    @TableField(exist = false)
    private String username;

    @TableField(exist = false)
    private String avatar;
}
