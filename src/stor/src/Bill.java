package stor.src;

import java.util.ArrayList;

public class Bill {

    private int id;
    private String customerName;
    private String date  ;
    public ArrayList<Products>products ;
    private double totalPrice;

    public int getId() {
        return id;
    }

    public void setProducts(ArrayList<Products> products) {
        this.products = products;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<Products> getProducts() {
        return products;
    }



    public double getTotalPrice() {
        return totalPrice;
    }


    public Bill(int id, String customerName, String date, ArrayList<Products> products, double totalPrice) {
        this.id = id;
        this.customerName = customerName;
        this.date = date;
        this.totalPrice = totalPrice;
    }
    public double getTotalPrice(ArrayList<Products> products ){
        double totalPrice = 0;
        for (Products produsts : products) {
            totalPrice +=produsts.getPrice();
        }
        return totalPrice;
    }


    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", date='" + date + '\'' +
                ", products=" + products +
                ", totalPrice=" + totalPrice +
                '}';
    }

    public ArrayList<ArrayList>AddProduct(){

        return new ArrayList<>();
    }
    public void addProducts(Products products){
        products.add(products);
    }
}
