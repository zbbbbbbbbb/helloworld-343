package com.iweb.service;

import com.iweb.entity.Property;
import com.iweb.entity.PropertyValue;

import java.util.List;

/**
 * @author 周博
 * @date 2023-04-05 19:57
 */
public interface PropertyValueService {
    List<PropertyValue> get(int pid);
    void update(PropertyValue propertyValue);
}
