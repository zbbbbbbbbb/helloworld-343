package com.iweb.DAO.Imp;



import com.iweb.DAO.ProductDAO;
import com.iweb.entity.Category;
import com.iweb.entity.Product;
import com.iweb.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class ProductDAOImp implements ProductDAO {
    @Override
    public List<Product> listProByCid(int cid) {
        ArrayList<Product> products = new ArrayList<>();
        String  sql="select * from product where cid = ?";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql)){
            ps.setInt(1,cid);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                final Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setSubTitle(rs.getString("SubTitle"));
                product.setOriginalPrice(rs.getFloat("OriginalPrice"));
                product.setPromotePrice(rs.getFloat("PromotePrice"));
                product.setStock(rs.getInt("stock"));
                Category category = new Category();
                category.setId(rs.getInt("cid"));
                product.setCategory(category);
                product.setCreateDate(rs.getDate("CreateDate"));
                products.add(product);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public int getTotal() {
        int count =0;
        String sql="select count(*) from product";
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
    public void insert(Product product) {
        String sql="insert into product(name,subTitle,originalPrice,promotePrice,stock,cid)values(?,?,?,?,?,?)";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){
          ps.setString(1,product.getName());
          ps.setString(2,product.getSubTitle());
          ps.setFloat(3,product.getOriginalPrice());
          ps.setFloat(4,product.getPromotePrice());
          ps.setInt(5,product.getStock());
          ps.setInt(6,product.getCategory().getId());
            ps.execute();
        }catch (Exception e)
        {e.printStackTrace();}
    }

    @Override
    public void update(Product product) {
        String sql="update product set name=?,subTitle=?,originalPrice=?,promotePrice=?,stock=? where id=?";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){
            ps.setString(1,product.getName());
            ps.setString(2,product.getSubTitle());
            ps.setFloat(3,product.getOriginalPrice());
            ps.setFloat(4,product.getPromotePrice());
            ps.setInt(5,product.getStock());
            ps.setInt(6,product.getId());
            ps.execute();
        }catch (Exception e)
        {e.printStackTrace();}
    }

    @Override
    public void delete(Integer id) {
        String sql="delete from product where id=?";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){
            ps.setInt(1,id);
            ps.execute();
        }catch (Exception e)
        {e.printStackTrace();}
    }

    @Override
    public List<Product> listAll() {
        return listAll(0,Integer.MAX_VALUE);
    }

    @Override
    public List<Product> listAll(int start, int count) {
        ArrayList<Product> products = new ArrayList<>();
        String  sql="select * from product limit ?,?";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){

            ps.setInt(1,start);
            ps.setInt(2,count);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                final Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setSubTitle(rs.getString("SubTitle"));
                product.setOriginalPrice(rs.getFloat("OriginalPrice"));
                product.setPromotePrice(rs.getFloat("PromotePrice"));
                product.setStock(rs.getInt("stock"));
                final Category category = new Category();
                category.setId(rs.getInt("cid"));
                product.setCategory(category);
                product.setCreateDate(rs.getDate("CreateDate"));
               products.add(product);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> listByNameLike(String keyword) {
        ArrayList<Product> products = new ArrayList<>();
        String sql="select * from product where name like  concat('%',?,'%')";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){
            ps.setString(1,keyword);
            final ResultSet rs = ps.executeQuery();
            while(rs.next()){
                final Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setSubTitle(rs.getString("SubTitle"));
                product.setOriginalPrice(rs.getFloat("OriginalPrice"));
                product.setPromotePrice(rs.getFloat("PromotePrice"));
                product.setStock(rs.getInt("stock"));
                final Category category = new Category();
                category.setId(rs.getInt("cid"));
                product.setCategory(category);
                product.setCreateDate(rs.getDate("CreateDate"));
                products.add(product);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product get(Integer id) {
       Product product=null;
        int n=0;
        String sql="select * from product where id = ? ";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){
            ps.setInt(1,id);
            final ResultSet rs = ps.executeQuery();
            while(rs.next()){
                 product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setSubTitle(rs.getString("SubTitle"));
                product.setOriginalPrice(rs.getFloat("OriginalPrice"));
                product.setPromotePrice(rs.getFloat("PromotePrice"));
                product.setStock(rs.getInt("stock"));
                Category category = new Category();
                category.setId(rs.getInt("cid"));
                product.setCategory(category);
                product.setCreateDate(rs.getDate("CreateDate"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return product;
    }
}
