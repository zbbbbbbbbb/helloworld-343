package com.iweb.service.impl;

import com.iweb.DAO.CategoryDAO;
import com.iweb.DAO.Imp.CategoryDAOImp;
import com.iweb.entity.Category;
import com.iweb.service.CategoryService;
import java.util.List;


public class CategoryServiceImpl implements CategoryService {
    CategoryDAO categoryDAO = new CategoryDAOImp();
    @Override
    public List<Category> list() {
        return categoryDAO.listAll();
    }

    @Override
    public void add(Category category) {
        categoryDAO.insert(category);
    }

    @Override
    public Category edit(int id) {
        return  categoryDAO.get(id);
    }

    @Override
    public void update(Category category) {
        categoryDAO.update(category);
    }

    @Override
    public void delete(Category category) {
        categoryDAO.delete(category.getId());
    }

    @Override
    public Category get(int id) {
        return categoryDAO.get(id);
    }
}
