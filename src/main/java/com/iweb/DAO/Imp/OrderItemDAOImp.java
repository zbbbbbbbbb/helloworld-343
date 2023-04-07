package com.iweb.DAO.Imp;

import com.iweb.DAO.OrderItemDAO;
import com.iweb.entity.Order;
import com.iweb.entity.OrderItem;
import com.iweb.entity.Product;
import com.iweb.entity.User;
import com.iweb.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class OrderItemDAOImp implements OrderItemDAO {
    @Override
    public int getTotal() {
        int count =0;
        String sql="select count(*) from orderItem";
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
    public void insert(OrderItem orderItem) {
        String sql="insert into orderItem(pid,oid,uid,number)values(?,?,?,?)";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){
            ps.setInt(1,orderItem.getProduct().getId());
            ps.setInt(2,orderItem.getOrder().getId());
            ps.setInt(3,orderItem.getUser().getId());
            ps.setInt(4,orderItem.getNumber());
            ps.execute();
        }catch (Exception e)
        {e.printStackTrace();}
    }

    @Override
    public void update(OrderItem orderItem) {
        String sql="update orderItem set number=? where id=?";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){
            ps.setInt(1,orderItem.getNumber());
            ps.setInt(2,orderItem.getId());

            ps.execute();
        }catch (Exception e)
        {e.printStackTrace();}
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<OrderItem> listAll() {
        return listAll(0,Integer.MAX_VALUE);
    }

    @Override
    public List<OrderItem> listAll(int start, int count) {
        ArrayList<OrderItem> order = new ArrayList<>();
        String  sql="select * from orderItem limit ?,?";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){

            ps.setInt(1,start);
            ps.setInt(2,count);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                final OrderItem orderItem = new OrderItem();
                ps.setInt(1,orderItem.getProduct().getId());
                ps.setInt(2,orderItem.getOrder().getId());
                ps.setInt(3,orderItem.getUser().getId());
                ps.setInt(4,orderItem.getNumber());
                order.add(orderItem);

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return order;
    }


    @Override
    public List<OrderItem> listByNameLike(String keyword) {
        ArrayList<OrderItem> order = new ArrayList<>();
        String sql="select * from orderItem where name like  concat('%',?,'%')";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){
            ps.setString(1,keyword);
            final ResultSet rs = ps.executeQuery();
            while(rs.next()){
                final OrderItem orderItem = new OrderItem();
                ps.setInt(1,orderItem.getProduct().getId());
                ps.setInt(2,orderItem.getOrder().getId());
                ps.setInt(3,orderItem.getUser().getId());
                ps.setInt(4,orderItem.getNumber());
                order.add(orderItem);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public OrderItem get(Integer id) {
       OrderItem order=null;
        int n=0;
        String sql="select * from orderItem where id = ? ";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){
            ps.setInt(1,id);
            final ResultSet rs = ps.executeQuery();
            while(rs.next()){
                order=new OrderItem();
                final User user = new User();
                user.setId(rs.getInt("uid"));
                final Product product = new Product();
                product.setId(rs.getInt("pid"));
                final Order order1 = new Order();
                order1.setId(rs.getInt("oid"));
                order.setUser(user);
                order.setProduct(product);
                order.setOrder(order1);
                order.setNumber(rs.getInt("number"));


            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return order;
    }
}
