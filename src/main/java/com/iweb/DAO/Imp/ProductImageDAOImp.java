package com.iweb.DAO.Imp;


import com.iweb.DAO.ProductImageDAO;
import com.iweb.entity.Product;
import com.iweb.entity.ProductImage;
import com.iweb.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProductImageDAOImp implements ProductImageDAO {
    @Override
    public List<ProductImage> getByPid(Integer pid) {
        List<ProductImage> list = new ArrayList<>();
        ProductImage productImage=null;
        String sql="select * from img where pid = ? ";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){
            ps.setInt(1,pid);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                productImage = new ProductImage();
                productImage.setId(rs.getInt("id"));
                productImage.setUrl(rs.getString("url"));
                Product product = new Product();
                product.setId(rs.getInt("pid"));
                productImage.setP(product);
                list.add(productImage);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ProductImage get(Integer id) {
        ProductImage productImage=null;
        String sql="select * from img where id = ? ";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                productImage = new ProductImage();
                productImage.setId(rs.getInt("id"));
                productImage.setUrl(rs.getString("url"));
                Product product = new Product();
                product.setId(rs.getInt("pid"));
                productImage.setP(product);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return productImage;
    }

    @Override
    public int getTotal() {
        int count =0;
        String sql="select count(*) from img";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){
            final ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        }catch (Exception e)
        {e.printStackTrace();}
        return count;
    }

    @Override
    public void insert(ProductImage productImage) {
        String sql="insert into img(url,pid)values(?,?)";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){
           ps.setString(1,productImage.getUrl());
           ps.setInt(2,productImage.getP().getId());
            ps.execute();
        }catch (Exception e)
        {e.printStackTrace();}
    }


    @Override
    public void update(ProductImage productImage) {
        String sql="update img set url=?,pid=? where id=?";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){
            ps.setString(1,productImage.getUrl());
            ps.setInt(2,productImage.getP().getId());
            ps.setInt(3,productImage.getId());
            ps.execute();
        }catch (Exception e)
        {e.printStackTrace();}
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<ProductImage> listAll() {
        return listAll(0,Integer.MAX_VALUE);
    }

    @Override
    public List<ProductImage> listAll(int start, int count) {
        ArrayList<ProductImage> products = new ArrayList<>();
        String  sql="select * from img  limit ?,?";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){

            ps.setInt(1,start);
            ps.setInt(2,count);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                final ProductImage productImage = new ProductImage();
                productImage.setId(rs.getInt("id"));
                productImage.setUrl(rs.getString("url"));
                final Product product = new Product();
                product.setId(rs.getInt("pid"));
                productImage.setP(product);
                products.add(productImage);

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return products;
    }
}
