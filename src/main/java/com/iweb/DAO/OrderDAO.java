package com.iweb.DAO;


import com.iweb.entity.Order;

import java.util.List;

/**
 * @author niu
 */
public interface OrderDAO {
    int getTotal();
    /**向订单表插入一条数据
     * @param order 要插入的数据的实体，向订单数据除了ID外所有属性
     * @return 返回是否插入成功
     */
    void insert(Order order);

    /** 基于id更改订单数据
     * @param order 要修改的数据的实体
     * @return 返回更新是否成功
     */
    void update(Order order);

    /**根据id对数据进行删除
     * 企业中的所有数据都是不做删除的，一般会在表中添加一个字段
     * isUse 0 1
     * @param id 要删除的数据的实体
     * @return
     */
    void delete(Integer id);

    /**查询所有数据
     * @return 所有分类对象的集合
     */
    List<Order> listAll();

    /**分页查询分类数据
     * @return 分页查询所有对象集合
     */
    List<Order> listAll(int start, int count);

    /**根据分类名称进行模糊查询
     * @param keyword
     * @return 模糊查询分类集合
     */
    List<Order> listByNameLike(String keyword);

    /**根据id获取对应的分类数据
     * @param id 分类的主要id
     * @return 得到分类对象
     */
    Order get(Integer id);

    void updates(Order order);
}
