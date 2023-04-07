package com.iweb.controller.admin;

import com.iweb.entity.Category;
import com.iweb.entity.Property;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author 周博
 * @date 2023-04-03 15:49
 */
@WebServlet("/propertyServlet")
public class PropertyServlet extends BaseBackServlet {
    public String list(HttpServletRequest request, HttpServletResponse response) {
        int cid = Integer.parseInt(request.getParameter("id"));
        List<Property> list = propertyService.listProperty(cid);
        if (list == null || list.isEmpty()) { // 如果list为null或者为空列表
            // 返回空列表对应的页面
            return "/page/admin/property/listProperty.jsp";
        }
        request.setAttribute("pr", list);
        return "/page/admin/property/listProperty.jsp";
    }

    public String add(HttpServletRequest request, HttpServletResponse response) {
        int cid = Integer.parseInt(request.getParameter("cid"));
        String name = request.getParameter("name");
        Property property = new Property();
        Category category = new Category();
        category.setId(cid);
        property.setName(name);
        property.setCategory(category);
        propertyService.insert(property);
        return "@/admin_property_list?id=" + cid;
    }

    public String delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        propertyService.delete(id);
        return "%success";
    }
    public String edit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Property property = propertyService.get(id);
        request.setAttribute("pt",property);
        int cid = property.getCategory().getId();
        request.setAttribute("cid",cid);
        return "/page/admin/property/edit.jsp";
    }
    public String update(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        int cid = Integer.parseInt(request.getParameter("cid"));
        String name = request.getParameter("name");
        Category category = new Category();
        category.setId(cid);
        Property property = new Property();
        property.setCategory(category);
        property.setId(id);
        property.setName(name);
        propertyService.update(property);
        return "@/admin_property_list?id=" + cid;
    }
}
