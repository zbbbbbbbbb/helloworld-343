package com.iweb.service;

import com.iweb.entity.Category;

import java.util.List;


public interface CategoryService {
    List<Category> list();
    void add(Category category);
    Category edit(int id);
    void update(Category category);
    void delete(Category category);
    Category get(int id);
}
