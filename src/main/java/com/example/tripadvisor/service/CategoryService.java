package com.example.tripadvisor.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.tripadvisor.mapper.CategoryMapper;
import com.example.tripadvisor.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    public Page<Category> findPage(int page, int size){
        Page selectPage = categoryMapper.selectPage(new Page(page,size),null);
        return selectPage;
    }

    public void add(Category category){
        categoryMapper.insert(category);
    }

    public Category findById(Integer id){
        return categoryMapper.selectById(id);
    }
    public void update(Category category){
        categoryMapper.updateById(category);
    }

    public void delete(Category cid){
        categoryMapper.deleteById(cid);
    }


    public List<Category> findAll(){
        return categoryMapper.selectList(null);
    }
}
