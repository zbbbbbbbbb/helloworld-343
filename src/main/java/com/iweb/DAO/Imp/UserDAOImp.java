package com.iweb.DAO.Imp;



import com.iweb.DAO.UserDAO;
import com.iweb.entity.User;
import com.iweb.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class UserDAOImp implements UserDAO {
    @Override
    public User get(String name,String password) {
        User user = null;
        String sql="select count(*) from  user where name=? and password = ?";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){
            ps.setString(1,name);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()&&rs.getInt(1)==1){
                user = new User();
                user.setName(name);
                user.setPassword(password);
            }
        }catch (Exception e)
        {e.printStackTrace();}
        return user;
    }
    @Override
    public int getTotal() {
        int count =0;
        String sql="select count(*) from  user";
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
    public void insert(User user) {
        String sql="insert into user(name,password)values(?,?)";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){
          ps.setString(1,user.getName());
          ps.setString(2,user.getPassword());
            ps.execute();
        }catch (Exception e)
        {e.printStackTrace();}
    }

    @Override
    public void update(User user) {
        String sql="update review set name=?,password=? where id=?";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){
            ps.setString(1,user.getName());
            ps.setString(2,user.getPassword());
            ps.setInt(3,user.getId());
            ps.execute();
        }catch (Exception e)
        {e.printStackTrace();}
    }
    @Override
    public void delete(Integer id) {

    }
    @Override
    public List<User> listAll() {
        return listAll(0,Integer.MAX_VALUE);
    }

    @Override
    public List<User> listAll(int start, int count) {
        ArrayList<User> users = new ArrayList<>();
        String  sql="select * from user limit ?,?";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){

            ps.setInt(1,start);
            ps.setInt(2,count);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                final User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("passwoed"));
                users.add(user);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return users;

    }
}
