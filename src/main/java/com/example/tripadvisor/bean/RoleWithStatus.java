package com.example.tripadvisor.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.example.tripadvisor.pojo.Permission;
import lombok.Data;

import java.util.List;

@Data
public class RoleWithStatus {
    private Integer rid;
    private String roleName;
    private String roleDesc;
    private Boolean adminHas;
}
