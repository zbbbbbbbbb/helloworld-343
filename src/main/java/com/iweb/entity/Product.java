package com.iweb.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Product {
    private String name;
    //小标题
    private String subTitle;
    private float originalPrice;
    private float promotePrice;
    private int stock;
    private Date createDate;
    private Category category;
    private int id;
    //评价数量
    private int reviewCount;
    // 销量
    private int saleCount;
    private List<ProductImage> images;
}
