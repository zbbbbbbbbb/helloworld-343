package com.iweb.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author Guan
 * @date 2023/3/30 9:13
 */
// 表示过滤器会过滤所有请求
    //过滤器中是不可以出现任何异常代码的 因为过滤器会伴随你tomcat的启动而自动启动
@WebFilter(urlPatterns = "/*")
public class A_CharacterEncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //对参数进行向下转型
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;
        req.setCharacterEncoding("UTF-8");
        //过滤器放行请求
        chain.doFilter(req,resp);
    }
    @Override
    public void destroy() {

    }
}
