package com.chernikin.webapp.web.servlets.action;


import com.chernikin.webapp.domain.Company;
import com.chernikin.webapp.domain.Cpu;
import com.chernikin.webapp.domain.Gpu;
import com.chernikin.webapp.domain.Product;
import com.chernikin.webapp.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/create-product-action")
public class CreateProductActionServlet extends HttpServlet {

    private ProductService productService = new ProductService();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product = new Product();
        product.setProductName(req.getParameter("productName"));
        product.setSpecification(req.getParameter("specification"));
        product.setPrice(Integer.parseInt(req.getParameter("price")));

        final Company company = new Company();
        company.setId(Integer.parseInt(req.getParameter("company")));
        final Cpu cpu = new Cpu();

        cpu.setId(Integer.parseInt(req.getParameter("cpu")));

        final Gpu gpu = new Gpu();
        gpu.setId(Integer.parseInt(req.getParameter("gpu")));

        product.setCompany(company);
        product.setCpu(cpu);
        product.setGpu(gpu);

        final int productId = productService.createProduct(product);
        if (productId != -1) {
            req.setAttribute("successMessage", "Registration of product is done!");
        } else {
            req.setAttribute("errorMessage", "Registration of product failed!");
        }
        resp.sendRedirect("manage-products-page");
    }
}
