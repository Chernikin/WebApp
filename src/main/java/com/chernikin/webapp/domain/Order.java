package com.chernikin.webapp.domain;

public class Order {

    private int id;
    private int orderId;
    private int idProduct;
    private String fName;
    private String lName;
    private String city;
    private int postNumber;
    private long cardNumber;
    private int month;
    private int year;
    private int cvv;


    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Order(int id, int orderId, int idProduct, String fName, String lName, String city, int postNumber, long cardNumber, int month, int year, int cvv) {
        this.id = id;
        this.orderId = orderId;
        this.idProduct = idProduct;
        this.fName = fName;
        this.lName = lName;
        this.city = city;
        this.postNumber = postNumber;
        this.cardNumber = cardNumber;
        this.month = month;
        this.year = year;
        this.cvv = cvv;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", idProduct=" + idProduct +
                ", city='" + city + '\'' +
                ", postNumber=" + postNumber +
                ", cardNumber=" + cardNumber +
                ", month=" + month +
                ", year=" + year +
                ", cvv=" + cvv +
                '}';
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostNumber() {
        return postNumber;
    }

    public void setPostNumber(int postNumber) {
        this.postNumber = postNumber;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
}
