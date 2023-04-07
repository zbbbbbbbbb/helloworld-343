package com.iweb.service.impl;

import com.iweb.DAO.ImgDAO;
import com.iweb.DAO.Imp.ImgDAOImpl;
import com.iweb.entity.ProductImage;
import com.iweb.service.ImgService;

import java.util.List;

/**
 * @author 周博
 * @date 2023-04-04 0:47
 */
public class ImgServiceImpl implements ImgService {
    ImgDAO imgDAO = new ImgDAOImpl();
    @Override
    public List<ProductImage> list(Integer pid) {
        return imgDAO.ImgByPid(pid);
    }

    @Override
    public void delete(Integer id) {
        imgDAO.delete(id);
    }

    @Override
    public void insert(ProductImage productImage) {
        imgDAO.insert(productImage);
    }
}
