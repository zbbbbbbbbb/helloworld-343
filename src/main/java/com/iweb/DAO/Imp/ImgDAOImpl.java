package com.iweb.DAO.Imp;

import com.iweb.DAO.ImgDAO;
import com.iweb.entity.Product;
import com.iweb.entity.ProductImage;
import com.iweb.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 周博
 * @date 2023-04-04 0:31
 */
public class ImgDAOImpl implements ImgDAO {
    @Override
    public List<ProductImage> ImgByPid(int pid) {
        List<ProductImage> list = new ArrayList<>();
        String sql = "select * from img where pid = ?";
        try (Connection c = JDBCUtil.getConnect();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1,pid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                ProductImage productImage = new ProductImage();
                Product product = new Product();
                productImage.setId(rs.getInt("id"));
                productImage.setUrl(rs.getString("url"));
                product.setId(rs.getInt("pid"));
                productImage.setP(product);
                list.add(productImage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void delete(Integer id) {
        String sql="delete from img where id=?";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){
            ps.setInt(1,id);
            ps.execute();
        }catch (Exception e)
        {e.printStackTrace();}
    }

    @Override
    public void insert(ProductImage productImage) {
        String sql="insert into img(url,pid) values(?,?)";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){
            ps.setString(1,productImage.getUrl());
            ps.setInt(2,productImage.getP().getId());
            ps.execute();
        }catch (Exception e)
        {e.printStackTrace();}
    }
}
