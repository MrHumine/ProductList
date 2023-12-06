package com.example.productlist;

public class Products {
    private int id;
    private String product;
    private String quantity;

    public Products(int id, String product, String quantity){
        this.product = product;
        this.id = id;
        this.quantity = quantity;
    }
    public Products(){};
    public void setId(int id){this.id = id;};
    public int getId(){return id;};
    public void setProduct(String product){this.product = product;};
    public void setQuantity(String quantity){this.quantity = quantity;};
    public String getProduct(){return product;};
    public String getQuantity(){return quantity;}
}
