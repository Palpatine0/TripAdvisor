package com.example.tripadvisor.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.List;

// 角色
@Data
public class Role {
    @TableId
    private Integer rid;
    private String roleName;
    private String roleDesc;
    @TableField(exist = false)
    private List<Permission> permissions;
}
