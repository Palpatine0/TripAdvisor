package com.example.tripadvisor.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.tripadvisor.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;

public interface ProductMapper extends BaseMapper<Product> {

    Page<Product> findProductPage(Page<Product> productPage);
    Product findById(int id);
    int findFavoritePidAndMid(@Param("pid")Integer pid,@Param("mid")Integer mid);

    void addFavorite(@Param("pid")Integer pid,@Param("mid")Integer mid);
    void delFavorite(@Param("pid")Integer pid,@Param("mid")Integer mid);

    Page<Product> findMemberFavoritePage(Page<Product> page,Integer mid);
    void deleteByProductId(Integer pid);

    int getSubmissionCountByMemberAndDate(@Param("mid") int memberId, @Param("date") LocalDate date);



}
