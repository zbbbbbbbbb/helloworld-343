package com.iweb.service.impl;

import com.iweb.DAO.Imp.PropertDAOImp;
import com.iweb.DAO.Imp.PropertyValueDAOImp;
import com.iweb.DAO.PropertValueDAO;
import com.iweb.DAO.PropertyDAO;
import com.iweb.entity.Property;
import com.iweb.entity.PropertyValue;
import com.iweb.service.PropertyValueService;

import java.util.List;

/**
 * @author 周博
 * @date 2023-04-05 19:59
 */
public class PropertyValueServiceImpl implements PropertyValueService {
    PropertValueDAO propertValueDAO = new PropertyValueDAOImp();
    PropertyDAO propertyDAO = new PropertDAOImp();
    @Override
    public List<PropertyValue> get(int pid) {
        List<PropertyValue> propertyValues = propertValueDAO.getValByPid(pid);
        for (PropertyValue p:propertyValues) {
            Property property = propertyDAO.get(p.getProperty().getId());
            p.setProperty(property);
        }
        return propertyValues;
    }

    @Override
    public void update(PropertyValue propertyValue) {
        propertValueDAO.update(propertyValue);
    }
}
