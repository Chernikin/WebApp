package com.chernikin.webapp.database.dao;

import com.chernikin.webapp.database.DatabaseConnectionManager;
import com.chernikin.webapp.database.ProductCriteria;
import com.chernikin.webapp.database.ProductQueryBuilder;
import com.chernikin.webapp.database.SqlQuery;
import com.chernikin.webapp.domain.Company;
import com.chernikin.webapp.domain.Cpu;
import com.chernikin.webapp.domain.Gpu;
import com.chernikin.webapp.domain.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ProductDAO implements GenericDao<Product> {

    private final ProductQueryBuilder productQueryBuilder = new ProductQueryBuilder();

    @Override
    public int create(Connection connection, Product product) {
        String sql = "INSERT INTO products(company_id, product_name, cpu_id, gpu_id, specification, price) VALUES(?,?,?,?,?,?)";
        int idCompany = product.getCompany().getId();
        int idCpu = product.getCpu().getId();
        int idGpu = product.getGpu().getId();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, idCompany);
            preparedStatement.setString(2, product.getProductName());
            preparedStatement.setInt(3, idCpu);
            preparedStatement.setInt(4, idGpu);
            preparedStatement.setString(5, product.getSpecification());
            preparedStatement.setInt(6, product.getPrice());
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Product getById(Connection connection, int productId) {
        String sql = "select * from products" +
                " join companies on products.company_id = companies.id" +
                " join cpu on products.cpu_id = cpu.id" +
                " join gpu on products.gpu_id = gpu.id" +
                " where products.id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, productId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return extractProductFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteById(Connection connection, int productId) {
        String sql = "DELETE FROM products WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, productId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product update(Connection connection, Product product) {
        String sql = "UPDATE products SET company_id = ?, product_name = ?, cpu_id = ?, gpu_id = ?, specification = ?, price = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, product.getCompany().getId());
            preparedStatement.setString(2, product.getProductName());
            preparedStatement.setInt(3, product.getCpu().getId());
            preparedStatement.setInt(4, product.getGpu().getId());
            preparedStatement.setString(5, product.getSpecification());
            preparedStatement.setInt(6, product.getPrice());
            preparedStatement.setInt(7, product.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public List<Product> getProductByCriteria(Connection connection, ProductCriteria criteria) {
        try {
            final SqlQuery sqlQuery = productQueryBuilder.buildSqlQuery(criteria);
            final String sql = sqlQuery.getSql();
            final Map<Integer, String> params = sqlQuery.getParams();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (Integer i : params.keySet()) {
                preparedStatement.setString(i, params.get(i));
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Product> products = new ArrayList<>();
            while (resultSet.next()) {
                products.add(extractProductFromResultSet(resultSet));
            }
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public List<Product> getAll(Connection connection) {
        String sql = "select * from products" +
                " join companies on products.company_id = companies.id" +
                " join cpu on products.cpu_id = cpu.id" +
                " join gpu on products.gpu_id = gpu.id";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            final List<Product> products = new ArrayList<>();
            while (resultSet.next()) {
                products.add(extractProductFromResultSet(resultSet));
            }
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private Product extractProductFromResultSet(ResultSet resultSet) throws SQLException {
        Product product = new Product();
        product.setId(resultSet.getInt("id"));
        product.setProductName(resultSet.getString("product_name"));
        product.setSpecification(resultSet.getString("specification"));
        product.setPrice(resultSet.getInt("price"));

        final Company company = new Company();
        final Cpu cpu = new Cpu();
        final Gpu gpu = new Gpu();

        company.setId(resultSet.getInt("company_id"));
        company.setCompanyName(resultSet.getString("company_name"));
        cpu.setId(resultSet.getInt("cpu_id"));
        cpu.setCpuName(resultSet.getString("cpu_name"));
        gpu.setId(resultSet.getInt("gpu_id"));
        gpu.setGpuName(resultSet.getString("gpu_name"));

        product.setCompany(company);
        product.setCpu(cpu);
        product.setGpu(gpu);

        return product;
    }
}
