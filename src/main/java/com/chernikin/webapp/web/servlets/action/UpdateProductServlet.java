package com.chernikin.webapp.web.servlets.action;

import com.chernikin.webapp.domain.Product;
import com.chernikin.webapp.database.dao.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/update")
public class UpdateProductServlet extends HttpServlet {

    private ProductDAO productDAO = new ProductDAO();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int productId = Integer.parseInt(req.getParameter("productId"));
        Product productById = productDAO.getById(productId);
        productById.setId(productId);
       // productById.getCompany().setIdCompany(Integer.parseInt(req.getParameter("companyId")));
        productById.setProductName(req.getParameter("productName"));
//        productById.getCpu().setIdCpu(Integer.parseInt(req.getParameter("cpuId")));
//        productById.getGpu().setIdGpu(Integer.parseInt(req.getParameter("gpuId")));
        productById.setSpecification(req.getParameter("specification"));
        productById.setPrice(Integer.parseInt(req.getParameter("price")));
        productDAO.update(productById);

        req.setAttribute("activeMessage", "Product with id: " + productById.getId() + " update!");

        req.getRequestDispatcher("generalPage").forward(req, resp);
    }
}