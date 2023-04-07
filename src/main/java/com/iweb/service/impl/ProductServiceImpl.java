package com.iweb.service.impl;

import com.iweb.DAO.ImgDAO;
import com.iweb.DAO.Imp.ImgDAOImpl;
import com.iweb.DAO.Imp.ProductDAOImp;
import com.iweb.DAO.ProductDAO;
import com.iweb.entity.Product;
import com.iweb.entity.ProductImage;
import com.iweb.service.ProductService;

import java.util.List;

/**
 * @author 周博
 * @date 2023-04-04 0:42
 */
public class ProductServiceImpl implements ProductService {
    ProductDAO productDAO = new ProductDAOImp();
    ImgDAO imgDAO = new ImgDAOImpl();
    @Override
    public List<Product> list(int cid) {
        return productDAO.listProByCid(cid);
    }
    public void ProductImg(List<Product> products){
        for (Product p:products) {
            List<ProductImage> productImages = imgDAO.ImgByPid(p.getId());
            if(productImages ==null ||productImages.size()==0){
                ProductImage productImage = new ProductImage();
                productImage.setUrl("https://dss2.bdstatic.com/5bVYsj_p_tVS5dKfpU_Y_D3/res/r/image/2021-3-4/hao123%20logo.png");
                productImages.add(productImage);
            }
            p.setImages(productImages);
        }
    }

    @Override
    public void insert(Product product) {
        productDAO.insert(product);
    }

    @Override
    public Product get(int id) {
        return productDAO.get(id);
    }

    @Override
    public void update(Product product) {
        productDAO.update(product);
    }

    @Override
    public void delete(Integer id) {
        productDAO.delete(id);
    }
}