package com.example.tripadvisor.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;


@Data
public class Member {
    @TableId
    private Integer mid;
    private String username;
    private String password;
    private String email;
    private String phoneNum;
    private String sex;
    private Integer score;
    private String avatar;

}
