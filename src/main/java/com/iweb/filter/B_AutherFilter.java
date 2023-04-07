package com.iweb.filter;//package com.iweb.filter;

import com.iweb.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Guan
 * @date 2023/3/30 9:38
 */
@WebFilter(urlPatterns = "/*")
public class B_AutherFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;
    //获取请求uri
        String uri = req.getRequestURI();
        //判断请求访问的是否是登录界面或者是提交登录信息的请求
        //如果是这两个请求 必须直接放行 否则会进入死循环
        if(uri.endsWith("login.jsp")||uri.endsWith("login")||uri.endsWith("gif")||uri.endsWith("jpg")||uri.endsWith("css")||uri.endsWith("js")){
            chain.doFilter(req,resp);
            return;
        }
        //我们这里省略cookie的操作 我们假设 登录成功 就直接把用户名存放在当前session中
        //这里过滤器就应该从session中获取用户名 判断是否为空 来判断用户是否成功登录
       User user = (User) req.getSession().getAttribute("user");
        if(null == user){
            resp.sendRedirect("/page/admin/login/login.jsp");
            return;
        }
        chain.doFilter(req,resp);
    }

    @Override
    public void destroy() {

    }
}
