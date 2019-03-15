package com.chernikin.webapp.database.dao;

import com.chernikin.webapp.domain.Company;
import com.chernikin.webapp.domain.Cpu;
import com.chernikin.webapp.domain.Gpu;
import com.chernikin.webapp.domain.Product;
import com.chernikin.webapp.database.ProductCriteria;
import com.chernikin.webapp.service.ProductService;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ProductDAOTest {

    @Ignore
    @Test
    public void returnNullWhenProductDataDelete() {
        ProductDAO productDAO = new ProductDAO();
        productDAO.deleteById(9);


    }

    @Ignore
    @Test
    public void returnProductIdIfProductSuccessfullySavedInDatabase() {

        ProductDAO productDAO = new ProductDAO();

        Product product = new Product();
//        product.getCompany().setIdCompany(1);
        product.setProductName("S 1");
        product.setSpecification("Hello S1");
        product.setPrice(111);
        int i = productDAO.create(product);

        assertTrue(i > -1);
    }

    @Ignore
    @Test
    public void returnNullIfProductUpdate() {
        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.getById(9);
//        product.getCompany().setIdCompany(5);
        Product updatedProduct = productDAO.update(product);

        assertNotNull(updatedProduct);
        assertEquals(6000, product.getPrice());
    }

    @Ignore
    @Test
    public void returnProductWhenProductDataExist(){
        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.getById(5);

        assertNotNull(product);
    }


    @Ignore
    @Test
    public void returnProductByCriteriaWhenProductDataExist(){
        ProductCriteria productCriteria = new ProductCriteria();
        ProductDAO productDAO = new ProductDAO();
        List<Product> product = productDAO.getProductByCriteria(productCriteria);

        assertNotNull(product);
        System.out.println(product);
    }


    @Ignore
    @Test
    public void returnProductIdAfterCreatedInProductService(){

        final ProductService productService = new ProductService();

        Product product = new Product();
        product.setProductName("test");
        product.setSpecification("test");
        product.setPrice(777);

        final Company company = new Company();
        company.setId(1);
        final Cpu cpu = new Cpu();

        cpu.setId(3);

        final Gpu gpu = new Gpu();
        gpu.setId(2);

        product.setCompany(company);
        product.setCpu(cpu);
        product.setGpu(gpu);

        final int productId = productService.createProduct(product);

        assertNotNull(productId);
        System.out.println(productId);
    }
}
