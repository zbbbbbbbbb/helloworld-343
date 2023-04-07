package com.iweb.entity;

import com.iweb.entity.Order;
import lombok.Data;

/**
 * @author 周博
 * @date 2023-04-03 9:13
 */

// 购物车中的数据和订单中的数据 绑定的都是订单详情 OrderItem
// 购物车中的订单详情 没有生成订单 可以默认将这些订单详情的oid设置为-1
// select * from orderitem where uid = 1 and oid = -1
//购物车进行结算的时候 相当于将这些关联oid为-1的订单详情 的oid统一设置为新创建的
//订单的id
@Data
public class OrderItem {
    private int number;
    private com.iweb.entity.Product product;
    private Order order;
    private com.iweb.entity.User user;
    private int id;
}
