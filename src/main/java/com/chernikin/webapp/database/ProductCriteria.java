package com.chernikin.webapp.database;

public class ProductCriteria {

    private String company;
    private String productName;
    private String price;


    @Override
    public String toString() {
        return "ProductCriteria{" +
                "Company='" + company + '\'' +
                ", productName='" + productName + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
