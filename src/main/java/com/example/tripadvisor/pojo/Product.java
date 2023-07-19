package com.example.tripadvisor.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
public class Product {
    @TableId
    private Integer pid;
    private String productName;
    private Boolean status;
    private String productDesc;
    private String pImage;
    private Integer cid;
    private Integer mid;
    private String username;
    private String created_date;


    @TableField(exist = false)
    private Category category;

}
