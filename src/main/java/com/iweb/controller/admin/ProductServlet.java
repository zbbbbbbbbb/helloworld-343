package com.iweb.controller.admin;

import com.iweb.entity.Category;
import com.iweb.entity.Product;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author 周博
 * @date 2023-04-04 0:16
 */
@WebServlet("/productServlet")
public class ProductServlet extends BaseBackServlet {
    public String list(HttpServletRequest request, HttpServletResponse response) {
        int cid = Integer.parseInt(request.getParameter("id"));
        List<Product> products = productService.list(cid);
        productService.ProductImg(products);
        request.setAttribute("pro", products);
        request.setAttribute("cid", cid);
        return "/page/admin/product/listProduct.jsp";
    }

    public String add(HttpServletRequest request, HttpServletResponse response) {
        int cid = Integer.parseInt(request.getParameter("cid"));
        String name = request.getParameter("name");
        String subTitle = request.getParameter("subTitle");
        float originalPrice = Float.parseFloat(request.getParameter("originalPrice"));
        float promotePrice = Float.parseFloat(request.getParameter("promotePrice"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        Product product = new Product();
        product.setName(name);
        product.setSubTitle(subTitle);
        product.setOriginalPrice(originalPrice);
        product.setPromotePrice(promotePrice);
        product.setStock(stock);
        Category category = new Category();
        category.setId(cid);
        product.setCategory(category);
        productService.insert(product);
        return "@admin_product_list?id=" + cid;
    }

    public String edit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.get(id);
        request.setAttribute("pro", product);
        return "/page/admin/product/editProduct.jsp";
    }

    public String update(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String subTitle = request.getParameter("subTitle");
        float originalPrice = Float.parseFloat(request.getParameter("originalPrice"));
        float promotePrice = Float.parseFloat(request.getParameter("promotePrice"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setSubTitle(subTitle);
        product.setOriginalPrice(originalPrice);
        product.setPromotePrice(promotePrice);
        product.setStock(stock);
        productService.update(product);
        return "@admin_product_list?id=" + id;
    }

    public String delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.delete(id);
        return "%success";
    }

}