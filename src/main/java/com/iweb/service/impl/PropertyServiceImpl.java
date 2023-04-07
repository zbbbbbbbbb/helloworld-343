package com.iweb.service.impl;

import com.iweb.DAO.Imp.PropertDAOImp;
import com.iweb.DAO.PropertyDAO;
import com.iweb.entity.Property;
import com.iweb.service.PropertyService;

import java.util.List;

/**
 * @author 周博
 * @date 2023-04-03 15:50
 */
public class PropertyServiceImpl implements PropertyService {
    PropertyDAO propertyDAO = new PropertDAOImp();
    @Override
    public List<Property> listProperty(int id) {
        return propertyDAO.getCidList(id);
    }

    @Override
    public void insert(Property property) {
        propertyDAO.insert(property);
    }

    @Override
    public void delete(int id) {
        propertyDAO.delete(id);
    }

    @Override
    public void update(Property property) {
        propertyDAO.update(property);
    }

    @Override
    public Property get(int id) {
        return propertyDAO.get(id);
    }
}
