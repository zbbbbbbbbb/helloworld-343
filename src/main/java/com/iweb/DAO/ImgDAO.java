package com.iweb.DAO;

import com.iweb.entity.ProductImage;

import java.util.List;

/**
 * @author 周博
 * @date 2023-04-04 0:29
 */
public interface ImgDAO {
    List<ProductImage> ImgByPid(int pid);

    void delete(Integer id);
    void insert(ProductImage productImage);
}
