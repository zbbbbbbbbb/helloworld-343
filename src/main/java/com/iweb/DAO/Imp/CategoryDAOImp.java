package com.iweb.DAO.Imp;

import com.iweb.DAO.CategoryDAO;
import com.iweb.entity.Category;
import com.iweb.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class CategoryDAOImp implements CategoryDAO {
    @Override
    public int getTotal() {
        int count =0;
        String sql="select count(*) from category";
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
    public void insert(Category category) {
        String sql="insert into category(name)values(?)";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){
            ps.setString(1,category.getName());
            ps.execute();
        }catch (Exception e)
        {e.printStackTrace();}
    }

    @Override
    public void update(Category category) {
        String sql="update category set name=? where id = ?";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){
            ps.setString(1,category.getName());
            ps.setInt(2,category.getId());
            ps.execute();
        }catch (Exception e)
        {e.printStackTrace();}
    }

    @Override
    public void delete(Integer id) {
        String sql="delete from category where id=?";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){
            ps.setInt(1,id);
            ps.execute();
        }catch (Exception e)
        {e.printStackTrace();}
    }

    @Override
    public List<Category> listAll() {
        return listAll(0,Integer.MAX_VALUE);
    }

    @Override
    public List<Category> listAll(int start, int count) {
        ArrayList<Category> categories = new ArrayList<>();
        String  sql="select * from category  limit ?,?";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){

            ps.setInt(1,start);
            ps.setInt(2,count);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                final Category category = new Category();
              category.setId(rs.getInt("id"));
              category.setName(rs.getString("name"));
              categories.add(category);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public List<Category> listByNameLike(String keyword) {
        ArrayList<Category> categories = new ArrayList<>();
        String sql="select * from category where name like  concat('%',?,'%')";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){
            ps.setString(1,keyword);
            final ResultSet rs = ps.executeQuery();
            while(rs.next()){
                final Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));

                categories.add(category);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public Category get(Integer id) {
       Category category = null;
        String sql="select * from category where id = ?";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){
            ps.setInt(1,id);
            final ResultSet rs = ps.executeQuery();
            while(rs.next()){
                category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return category;
    }
    @Override
    public void updates(Category category) {
        String sql="update category set name=?";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){
            ps.setString(1,category.getName());
            ps.execute();
        }catch (Exception e)
        {e.printStackTrace();}
    }
}
