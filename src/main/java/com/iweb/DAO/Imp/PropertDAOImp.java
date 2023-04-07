package com.iweb.DAO.Imp;
import com.iweb.DAO.PropertyDAO;
import com.iweb.entity.Category;
import com.iweb.entity.Property;
import com.iweb.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class PropertDAOImp implements PropertyDAO {
    @Override
    public Property get(int id) {
        Property property = null;
        Category category = null;
        String sql="select * from property where id = ? ";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql)){
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                property = new Property();
                property.setId(rs.getInt("id"));
                category = new Category();
                category.setId(rs.getInt("cid"));
                property.setCategory(category);
                property.setName(rs.getString("name"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return property;
    }

    @Override
    public List<Property> getCidList(Integer cid) {
        List<Property> lists = new ArrayList<>();
        Property property = null;
        String sql="select * from property where cid = ? ";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){
            ps.setInt(1,cid);
            final ResultSet rs = ps.executeQuery();
            while(rs.next()){
                property = new Property();
                property.setId(rs.getInt("id"));
                Category category = new Category();
                category.setId(rs.getInt("cid"));
                property.setCategory(category);
                property.setName(rs.getString("name"));
                lists.add(property);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return lists;
    }

    @Override
    public Property get(Integer id) {
       Property property=null;
        String sql="select * from property where id = ? ";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                property = new Property();
                property.setId(rs.getInt("id"));
                Category category = new Category();
                category.setId(rs.getInt("cid"));
                property.setCategory(category);
                property.setName(rs.getString("name"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return property;
    }

    @Override
    public int getTotal() {
        int count =0;
        String sql="select count(*) from  property";
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
    public void insert(Property property) {
        String sql="insert into property(name,cid)values(?,?)";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql)){
            ps.setString(1,property.getName());
            ps.setInt(2,property.getCategory().getId());
            ps.execute();
        }catch (Exception e)
        {e.printStackTrace();}
    }

    @Override
    public void update(Property property) {
        String sql="update property set cid=?,name=? where id=?";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){
            ps.setInt(1,property.getCategory().getId());
            ps.setString(2,property.getName());
            ps.setInt(3,property.getId());
            ps.execute();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String sql="delete from property where id=?";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){
            ps.setInt(1,id);
            ps.execute();
        }catch (Exception e)
        {e.printStackTrace();}
    }

    @Override
    public List<Property> listAll() {
        return listAll(0,Integer.MAX_VALUE);
    }

    @Override
    public List<Property> listAll(int start, int count) {
        ArrayList<Property> propertys = new ArrayList<>();
        String  sql="select * from property limit ?,?";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){

            ps.setInt(1,start);
            ps.setInt(2,count);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                final Property property = new Property();
               property.setId(rs.getInt("id"));
                final Category category = new Category();
                category.setId(rs.getInt("cid"));
                property.setCategory(category);
                property.setName(rs.getString("name"));
                propertys.add(property);

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return propertys;
    }
}
