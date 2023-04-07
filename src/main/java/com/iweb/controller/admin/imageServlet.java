package com.iweb.controller.admin;

import com.iweb.entity.Product;
import com.iweb.entity.ProductImage;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author 周博
 * @date 2023-04-06 0:24
 */
@WebServlet("/imageServlet")
public class imageServlet extends BaseBackServlet {
    public String list(HttpServletRequest request, HttpServletResponse response) {
        int pid = Integer.parseInt(request.getParameter("id"));
        List<ProductImage> productImages = imgService.list(pid);
        request.setAttribute("images", productImages);
        request.setAttribute("pid", pid);
        return "/page/admin/image/setImage.jsp";
    }

    public String delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        imgService.delete(id);
        return "%success";
    }
    public String insert(HttpServletRequest request, HttpServletResponse response) {
        int pid = Integer.parseInt(request.getParameter("pid"));
        String url = request.getParameter("url");
        Product product = new Product();
        product.setId(pid);
        ProductImage productImage = new ProductImage();
        productImage.setUrl(url);
        productImage.setP(product);
        imgService.insert(productImage);
        return "@admin_image_list?id="+pid;
    }
}
