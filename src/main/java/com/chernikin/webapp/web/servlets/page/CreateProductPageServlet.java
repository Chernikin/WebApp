package com.chernikin.webapp.web.servlets.page;

import com.chernikin.webapp.domain.Company;
import com.chernikin.webapp.domain.Cpu;
import com.chernikin.webapp.domain.Gpu;
import com.chernikin.webapp.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/create-product-page")
public class CreateProductPageServlet extends HttpServlet {

    private ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final List<Company> allCompanies = productService.getAllCompanies();
        final List<Cpu> allCpu = productService.getAllCpu();
        final List<Gpu> allGpu = productService.getAllGpu();
        req.setAttribute("allCompanies", allCompanies);
        req.setAttribute("allCpu", allCpu);
        req.setAttribute("allGpu", allGpu);

        req.getRequestDispatcher("create-product-page.jsp").forward(req, resp);
    }
}
