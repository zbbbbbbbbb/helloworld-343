package com.iweb.controller.admin;

import com.iweb.entity.PropertyValue;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author 周博
 * @date 2023-04-05 20:25
 */
@WebServlet("/propertyValueServlet")
public class PropertyValueServlet extends BaseBackServlet {
    public String list(HttpServletRequest request, HttpServletResponse response) {
        int pid = Integer.parseInt(request.getParameter("id"));
        List<PropertyValue> propertyValues = propertyValueService.get(pid);
        request.setAttribute("pv", propertyValues);
        return "/page/admin/product/setPropertyValue.jsp";
    }

    public String update(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String value = request.getParameter("value");
        System.out.println(value + ":value");
        System.out.println(id + ":id");
        PropertyValue propertyValue = new PropertyValue();
        propertyValue.setId(id);
        propertyValue.setValue(value);
        propertyValueService.update(propertyValue);
        return "%success";
    }
}
