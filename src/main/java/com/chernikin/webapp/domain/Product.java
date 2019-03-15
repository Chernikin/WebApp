package com.chernikin.webapp.domain;

public class Product {

    private int id;
    private Company company;
    private String productName;
    private Cpu cpu;
    private Gpu gpu;
    private String specification;
    private int price;

    public Product() {
    }

    public Product(Company company, String productName, Cpu cpu, Gpu gpu, String specification, int price) {
        this.company = company;
        this.productName = productName;
        this.cpu = cpu;
        this.gpu = gpu;
        this.specification = specification;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Cpu getCpu() {
        return cpu;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public Gpu getGpu() {
        return gpu;
    }

    public void setGpu(Gpu gpu) {
        this.gpu = gpu;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", company=" + company +
                ", productName='" + productName + '\'' +
                ", cpu=" + cpu +
                ", gpu=" + gpu +
                ", specification='" + specification + '\'' +
                ", price=" + price +
                '}';
    }
}
