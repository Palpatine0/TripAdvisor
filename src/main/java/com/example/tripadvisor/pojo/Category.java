package com.example.tripadvisor.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Category{
    @TableId
    private Integer cid;
    private String cname;
}
