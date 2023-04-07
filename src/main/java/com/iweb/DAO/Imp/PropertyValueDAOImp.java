package com.iweb.DAO.Imp;


import com.iweb.DAO.PropertValueDAO;
import com.iweb.entity.Product;
import com.iweb.entity.Property;
import com.iweb.entity.PropertyValue;
import com.iweb.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class PropertyValueDAOImp implements PropertValueDAO {
    @Override
    public List<PropertyValue> getValByPid(Integer pid) {
        List<PropertyValue> list = new ArrayList<>();
        PropertyValue propertyValue = null;
        String sql = "select * from propertyValue where pid = ? ";
        try (Connection c = JDBCUtil.getConnect();
             PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1, pid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                propertyValue = new PropertyValue();
                propertyValue.setId(rs.getInt("id"));
                propertyValue.setValue(rs.getString("value"));
                Product product = new Product();
                product.setId(rs.getInt("pid"));
                Property property = new Property();
                property.setId(rs.getInt("ptid"));
                propertyValue.setProperty(property);
                propertyValue.setProduct(product);
                list.add(propertyValue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int getTotal() {
        int count = 0;
        String sql = "select count(*) from  propertyValue";
        try (Connection c = JDBCUtil.getConnect();
             PreparedStatement ps = c.prepareStatement(sql);) {
            final ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public void insert(PropertyValue propertyValue) {
        String sql = "insert into propertyValue(pid,ptid,value)values(?,?,?)";
        try (Connection c = JDBCUtil.getConnect();
             PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1, propertyValue.getProduct().getId());
            ps.setInt(2, propertyValue.getProperty().getId());
            ps.setString(3, propertyValue.getValue());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(PropertyValue propertyValue) {
        String sql = "update propertyvalue set value=? where id=?";
        try (Connection c = JDBCUtil.getConnect();
             PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1, propertyValue.getValue());
            ps.setInt(2, propertyValue.getId());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from propertyvalue where id=?";
        try (Connection c = JDBCUtil.getConnect();
             PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1, id);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<PropertyValue> listAll() {
        return listAll(0, Integer.MAX_VALUE);
    }

    @Override
    public List<PropertyValue> listAll(int start, int count) {
        ArrayList<PropertyValue> propertyValues = new ArrayList<>();
        String sql = "select * from propertyValue  limit ?,?";
        try (Connection c = JDBCUtil.getConnect();
             PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setInt(1, start);
            ps.setInt(2, count);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                final PropertyValue propertyValue = new PropertyValue();
                propertyValue.setValue(rs.getString("value"));
                final Product product = new Product();
                product.setId(rs.getInt("pid"));
                final Property property = new Property();
                property.setId(rs.getInt("ptid"));
                propertyValue.setProperty(property);
                propertyValue.setProduct(product);
                propertyValues.add(propertyValue);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return propertyValues;
    }

    @Override
    public PropertyValue get(Integer id) {
        PropertyValue propertyValue = null;
        int n = 0;
        String sql = "select * from propertyValue where id = ? ";
        try (Connection c = JDBCUtil.getConnect();
             PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1, id);
            final ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                propertyValue = new PropertyValue();
                propertyValue.setValue(rs.getString("value"));
                final Product product = new Product();
                product.setId(rs.getInt("pid"));
                final Property property = new Property();
                property.setId(rs.getInt("ptid"));
                propertyValue.setProperty(property);
                propertyValue.setProduct(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return propertyValue;
    }


}
