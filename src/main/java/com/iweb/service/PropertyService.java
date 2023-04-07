package com.iweb.service;

import com.iweb.DAO.Imp.PropertDAOImp;
import com.iweb.DAO.PropertyDAO;
import com.iweb.entity.Category;
import com.iweb.entity.Property;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 周博
 * @date 2023-04-03 15:49
 */
public interface PropertyService {
    Property get(int id);
    List<Property> listProperty(int cid);
    void insert(Property property);
    void delete(int id);
    void update(Property property);
}
