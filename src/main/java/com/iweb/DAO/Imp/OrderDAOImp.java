package com.iweb.DAO.Imp;


import com.iweb.DAO.OrderDAO;
import com.iweb.entity.Order;
import com.iweb.entity.User;
import com.iweb.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class OrderDAOImp implements OrderDAO {

    @Override
    public int getTotal() {
        int count =0;
        String sql="select count(*) from order_";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){
            final ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public void insert(Order order) {
        String sql="insert into order_(orderCode,address,post,receiver,mobilie,userMessage,createDate,payDate,deliveryDate,confirmDate,uid,status )values(?,?,?,?,?,?,?,?,?,?,?,?)";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){
            ps.setString(1,order.getOrderCode());
            ps.setString(2,order.getAddress());
            ps.setString(3,order.getPost());
            ps.setString(4,order.getReceiver());
            ps.setString(5,order.getMobile());
            ps.setString(6,order.getUserMessage());
            ps.setTimestamp(7,new Timestamp(System.currentTimeMillis()));
            ps.setTimestamp(8,new Timestamp(System.currentTimeMillis()));
            ps.setTimestamp(9,new Timestamp(System.currentTimeMillis()));
            ps.setTimestamp(10,new Timestamp(System.currentTimeMillis()));
            ps.setInt(11,order.getUser().getId());
            ps.setString(12,order.getStatus());
            ps.execute();
        }catch (Exception e)
        {e.printStackTrace();}
    }
    @Override
    public void update(Order order) {
        String sql="update order_ set address=?,post=?,receiver=?,mobilie=?,userMessage=?,uid=?,status=? where orderCode=?";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){
           ps.setString(1,order.getAddress());
           ps.setString(2,order.getPost());
           ps.setString(3,order.getReceiver());
           ps.setString(4,order.getMobile());
           ps.setString(5,order.getUserMessage());
           ps.setInt(6,order.getUser().getId());
           ps.setString(7,order.getStatus());
           ps.setString(8,order.getOrderCode());
            ps.execute();
        }catch (Exception e)
        {e.printStackTrace();}
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Order> listAll() {
        return listAll(0,Integer.MAX_VALUE);
    }

    @Override
    public List<Order> listAll(int start, int count) {
        ArrayList<Order> orders = new ArrayList<>();
        String  sql="select * from order_  limit ?,?";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){

            ps.setInt(1,start);
            ps.setInt(2,count);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                final Order order = new Order();
                order.setOrderCode(rs.getString("orderCode"));
                order.setAddress(rs.getString("address"));
                order.setPost(rs.getString("post"));
                order.setReceiver(rs.getString("receiver"));
                order.setMobile(rs.getString("mobile"));
                order.setUserMessage(rs.getString("userMessage"));
                order.setCreateDate(rs.getDate("createDate"));
                order.setPayDate(rs.getDate("payDate"));
                order.setDeliveryDate(rs.getDate("deliverDate"));
                order.setConfirmDate(rs.getDate("confirmDate"));
                final User user = new User();
                user.setId(rs.getInt("uid"));
                order.setUser(user);
                order.setStatus(rs.getString("status"));
                orders.add(order);

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public List<Order> listByNameLike(String keyword) {
        ArrayList<Order> orders = new ArrayList<>();
        String sql="select * from order_ where name like  concat('%',?,'%')";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){
            ps.setString(1,keyword);
            final ResultSet rs = ps.executeQuery();
            while(rs.next()){
                final Order order = new Order();
                order.setOrderCode(rs.getString("orderCode"));
                order.setAddress(rs.getString("address"));
                order.setPost(rs.getString("post"));
                order.setReceiver(rs.getString("receiver"));
                order.setMobile(rs.getString("mobile"));
                order.setUserMessage(rs.getString("userMessage"));
                order.setCreateDate(rs.getDate("createDate"));
                order.setPayDate(rs.getDate("payDate"));
                order.setDeliveryDate(rs.getDate("deliverDate"));
                order.setConfirmDate(rs.getDate("confirmDate"));
                final User user = new User();
                user.setId(rs.getInt("uid"));
                order.setUser(user);
                order.setStatus(rs.getString("status"));
                orders.add(order);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public Order get(Integer id) {
        Order order = null;
        int n=0;
        String sql="select * from order_ where id = ? and isdelete= ?";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){
            ps.setInt(1,id);
            ps.setInt(2,n);
            final ResultSet rs = ps.executeQuery();
            while(rs.next()){
                order=new Order();
                order.setOrderCode(rs.getString("orderCode"));
                order.setAddress(rs.getString("address"));
                order.setPost(rs.getString("post"));
                order.setReceiver(rs.getString("receiver"));
                order.setMobile(rs.getString("mobile"));
                order.setUserMessage(rs.getString("userMessage"));
                order.setCreateDate(rs.getDate("createDate"));
                order.setPayDate(rs.getDate("payDate"));
                order.setDeliveryDate(rs.getDate("deliverDate"));
                order.setConfirmDate(rs.getDate("confirmDate"));
                final User user = new User();
                user.setId(rs.getInt("uid"));
                order.setUser(user);
                order.setStatus(rs.getString("status"));

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public void updates(Order order) {

    }
}
