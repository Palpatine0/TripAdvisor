package com.example.tripadvisor.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.tripadvisor.mapper.ProductMapper;
import com.example.tripadvisor.pojo.Category;
import com.example.tripadvisor.pojo.Permission;
import com.example.tripadvisor.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductMapper productMapper;

    public Page<Product> findPage(int page, int size){
        Page<Product> selectPage = productMapper.findProductPage(new Page(page,size));
        return selectPage;
    }

    public void add(Product product){
        productMapper.insert(product);
    }

    public Product findById(int id){
        return productMapper.findById(id);
    }

    public void update(Product product){
        productMapper.updateById(product);
    }

    public void updateStatus(Integer pid){
        Product product = productMapper.selectById(pid);
        product.setStatus(!product.getStatus());
        productMapper.updateById(product);
    }

    public Page<Product> findProduct(Integer cid,String productName,int page,int size){
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        if (cid!=null){
            queryWrapper.eq("cid",cid);
        }
        if (StringUtils.hasText(productName)){
            queryWrapper.like("productName",productName);
        }
        //make sure its a available product
        queryWrapper.eq("status",1);
        queryWrapper.orderByDesc("pid");
        Page selectedPage = productMapper.selectPage(new Page(page,size),queryWrapper);
        return selectedPage;
    }



    public void delete(Product pid){
        productMapper.deleteByProductId(pid.getPid());
        productMapper.deleteById(pid);
    }

    public List<Product> findAll(){
        return productMapper.selectList(null);
    }
}
