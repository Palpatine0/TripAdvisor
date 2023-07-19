package com.example.tripadvisor.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;


@Data
public class Permission {
    @TableId
    private Integer pid;
    private String permissionName;
    private String permissionDesc;
}
