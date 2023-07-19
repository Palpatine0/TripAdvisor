package com.example.tripadvisor.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import java.util.List;

@Data
public class Admin {
    @TableId
    private Integer aid;
    private String username;
    private String password;
    private String phoneNum;
    private String email;
    private boolean status;
    @TableField(exist = false)
    private List<Role> roles;
}
