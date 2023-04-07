package com.iweb.service;

import com.iweb.entity.ProductImage;

import java.util.List;

/**
 * @author 周博
 * @date 2023-04-04 0:47
 */
public interface ImgService {
    List<ProductImage> list(Integer pid);
    void delete(Integer id);
    void insert(ProductImage productImage);
}
