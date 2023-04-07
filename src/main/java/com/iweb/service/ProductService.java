package com.iweb.service;

import com.iweb.entity.Product;
import com.iweb.entity.ProductImage;

import java.util.List;

/**
 * @author 周博
 * @date 2023-04-04 0:42
 */
public interface ProductService {
    List<Product> list(int cid);
    void ProductImg(List<Product> products);
    void insert(Product product);
    Product get(int id);
    void update(Product product);
    void delete(Integer id);
}
