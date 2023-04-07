package com.iweb.entity;

import lombok.Data;

@Data
public class PropertyValue {
    private String value;
    private Product product;
    private Property property;
    private int id;
}
