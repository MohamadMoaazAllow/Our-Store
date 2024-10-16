package stor.src;

import java.util.ArrayList;

public class Customer {
    private int id;
    private String name;
    private int age;
    private String address;
    private ArrayList<ArrayList> bills = null;
    private double balance;

    public Customer(int id, String name, int age, String address, ArrayList<ArrayList> bills, double balance) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.bills = bills;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<ArrayList> getBills() {
        return bills;
    }

    public void setBills(ArrayList<ArrayList> bills) {
        this.bills = bills;
    }

    public String getAddress() {
        return address;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", bills=" + bills +
                ", balance=" + balance +
                '}';
    }
    public String bills(){
        return "bills : "+'\''
                +bills;
    }
//    public static void updateBalance(double newBalance,getBalance){
//        Balance += newBalance;
//    }
}
