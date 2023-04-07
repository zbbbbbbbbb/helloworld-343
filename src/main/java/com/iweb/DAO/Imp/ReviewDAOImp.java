package com.iweb.DAO.Imp;

import com.iweb.DAO.ReviewDAO;
import com.iweb.entity.Product;
import com.iweb.entity.Review;
import com.iweb.entity.User;
import com.iweb.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class ReviewDAOImp implements ReviewDAO {
    @Override
    public Review get(Integer id) {
        Review review=null;
        int n=0;
        String sql="select * from propertyValue where id = ? ";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){
            ps.setInt(1,id);
            final ResultSet rs = ps.executeQuery();
            while(rs.next()){
                review = new Review();
                review.setId(rs.getInt("id"));
                review.setContent(rs.getString("content"));
                final User user = new User();
                user.setId(rs.getInt("uid"));
                final Product product = new Product();
                product.setId(rs.getInt("pid"));
                review.setUser(user);
                review.setProduct(product);
                review.setCreateDate(rs.getDate("createDate"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return review;
    }


    @Override
    public int getTotal() {
        int count =0;
        String sql="select count(*) from  review";
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
    public void insert(Review review) {
        String sql="insert into review(content,uid,pid,createDate)values(?,?,?,?)";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){
          ps.setString(1,review.getContent());
          ps.setInt(2,review.getUser().getId());
          ps.setInt(3,review.getProduct().getId());
            ps.setTimestamp(4,new Timestamp(System.currentTimeMillis()));
            ps.execute();
        }catch (Exception e)
        {e.printStackTrace();}
    }

    @Override
    public void update(Review review) {
        String sql="update review set content=?,uid=?,pid=? where id=?";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){
            ps.setString(1,review.getContent());
            ps.setInt(2,review.getUser().getId());
            ps.setInt(3,review.getProduct().getId());
            ps.setInt(4,review.getId());
            ps.execute();
        }catch (Exception e)
        {e.printStackTrace();}
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Review> listAll() {
        return listAll(0,Integer.MAX_VALUE);
    }

    @Override
    public List<Review> listAll(int start, int count) {
        ArrayList<Review> reviews = new ArrayList<>();
        String  sql="select * from review limit ?,?";
        try(Connection c= JDBCUtil.getConnect();
            PreparedStatement ps=c.prepareStatement(sql);){

            ps.setInt(1,start);
            ps.setInt(2,count);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                final Review review = new Review();
                review.setId(rs.getInt("id"));
                review.setContent(rs.getString("content"));
                final User user = new User();
                user.setId(rs.getInt("uid"));
                final Product product = new Product();
                product.setId(rs.getInt("pid"));
                review.setUser(user);
                review.setProduct(product);
                review.setCreateDate(rs.getDate("createDate"));
                reviews.add(review);


            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return reviews;
    }
}
