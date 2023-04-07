package com.iweb.controller.admin;

import com.iweb.entity.Category;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@WebServlet("/categoryServlet")
public class CategoryServlet extends BaseBackServlet {
    public String list(HttpServletRequest request, HttpServletResponse response) {
        //调用service获取集合
        List<Category> categories = categoryService.list();
        //获取到的集合存入到请求中
        request.setAttribute("cs", categories);
        //通过转发跳转到对应的jsp页面 页面通过el表达式将数据渲染出来
        return "/page/admin/category/listCategory.jsp";
    }

    public String add(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        Category category = new Category();
        category.setName(name);
        categoryService.add(category);
        //重定向
        return "@/admin_category_list";
    }

    public String edit(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Category category = categoryService.edit(id);
        request.setAttribute("c", category);
        return "/page/admin/category/editCategory.jsp";
    }

    public String update(HttpServletRequest request, HttpServletResponse response) {
        Category category = new Category();
        category.setId(Integer.parseInt(request.getParameter("id")));
        category.setName(request.getParameter("name"));
        categoryService.update(category);
        return "@/admin_category_list";
    }

    public String delete(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Category category = new Category();
        category.setId(id);
        categoryService.delete(category);
        return "%success";
    }

}
