package patrons;

import books.Book;
import patrons.ibasicoperations.IBasicOperations;

abstract public class Patron implements IBasicOperations {

    private int id;
    private String name;
    private String departmentName;
    private String email;
    private String contactNo;
    private String address;
    private double amount;

    private Book bookBorrow;       // Made by us

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setBookBorrow(Book bookBorrow) {       // Made by us
        this.bookBorrow = bookBorrow;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getContactNo() {
        return this.contactNo;
    }

    public String getAddress() {
        return this.address;
    }

    public double getAmount() {
        return this.amount;
    }

    public Book getBookBorrow() {       // Made by us
        return this.bookBorrow;
    }

    abstract public void showInfo();

}