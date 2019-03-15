package com.chernikin.webapp.service;

import com.chernikin.webapp.database.DatabaseConnectionManager;
import com.chernikin.webapp.database.dao.CompanyDao;
import com.chernikin.webapp.database.dao.CpuDao;
import com.chernikin.webapp.database.dao.GpuDao;
import com.chernikin.webapp.database.dao.ProductDAO;
import com.chernikin.webapp.domain.Company;
import com.chernikin.webapp.domain.Cpu;
import com.chernikin.webapp.domain.Gpu;
import com.chernikin.webapp.domain.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProductService {

    private ProductDAO productDAO = new ProductDAO();
    private CompanyDao companyDao = new CompanyDao();
    private CpuDao cpuDao = new CpuDao();
    private GpuDao gpuDao = new GpuDao();

    public Product getProductById(int productId) {
        Connection connection = null;
        try {
            connection = DatabaseConnectionManager.getConnection();
            return productDAO.getById(connection, productId);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DatabaseConnectionManager.closeConnection(connection);
        }return null;
    }

    public int createProduct(Product product) {
        Connection connection = null;
        try {
            connection = DatabaseConnectionManager.getConnection();
            final int productId = productDAO.create(connection, product);
            connection.commit();
            return productId;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnectionManager.closeConnection(connection);
        }
        return -1;
    }

    public void deleteProductById(int productId) {
        productDAO.deleteById(productId);
    }

    public Product updateProduct(Product product) {
        return productDAO.update(product);
    }

    public List<Product> getAllProducts() {
        return productDAO.getAll();
    }

    public List<Company> getAllCompanies() {
        return companyDao.getAll();
    }

    public List<Cpu> getAllCpu(){
        return cpuDao.getAll();
    }

    public List<Gpu> getAllGpu(){
        return gpuDao.getAll();
    }
}
