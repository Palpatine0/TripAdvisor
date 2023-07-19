package com.example.tripadvisor.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class PermissionWithStatus {
    private Integer pid;
    private String permissionName;
    private String permissionDesc;
    private Boolean roleHas;
}
