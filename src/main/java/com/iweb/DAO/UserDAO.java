package com.iweb.DAO;


import com.iweb.entity.User;

import java.util.List;

public interface UserDAO  {
    public User get(String name, String password);
    int getTotal();
    void insert(User user);

    /** 基于id更改分类数据
     * @param user 要修改的数据的实体
     * @return 返回更新是否成功
     */
    void update(User user);

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
    List<User> listAll();

    /**分页查询分类数据
     * @return 分页查询所有对象集合
     */
    List<User> listAll(int start, int count);
}
