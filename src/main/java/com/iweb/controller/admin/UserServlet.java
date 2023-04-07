package com.iweb.controller.admin;

import com.iweb.entity.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/userServlet")
public class UserServlet extends BaseBackServlet {
    public String exitLogin(HttpServletRequest request, HttpServletResponse response){
        request.getSession().removeAttribute("user");
        return "@/page/admin/login/login.jsp";
    }
    public String login(HttpServletRequest request, HttpServletResponse response){
        //接收参数并封装
        User user=new User();
        user.setName(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        //调用service进行处理
        boolean isLogin= loginService.login(user);
        //如果成功 应该将用户信息存入session 用于后续校验
        if (isLogin){
            request.getSession().setAttribute("user",user);
            return "@/admin_category_list";
        }else {
            return "@/page/admin/login/login.jsp";
        }
    }
}
