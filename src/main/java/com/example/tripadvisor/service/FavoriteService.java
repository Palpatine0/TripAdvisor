package com.example.tripadvisor.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.tripadvisor.mapper.ProductMapper;
import com.example.tripadvisor.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoriteService {
    @Autowired
    private ProductMapper productMapper;

    public boolean findFavorite(Integer pid,Integer mid){
        int result = productMapper.findFavoritePidAndMid(pid, mid);
        if (result == 0){
            return false;
        }else {
            return true;
        }
    }

    public void addFavorite(Integer pid,Integer mid){
        productMapper.addFavorite(pid,mid);
    }
    public void delFavorite(Integer pid,Integer mid){
        productMapper.delFavorite(pid,mid);
    }

    public Page<Product> findMemberFavoritePage (int page,int size,Integer mid){
        Page favoriteProduct = productMapper.findMemberFavoritePage(new Page(page, size), mid);
        return favoriteProduct;
    }
}
