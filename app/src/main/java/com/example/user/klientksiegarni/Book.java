package com.example.user.klientksiegarni;

public class Book {

    private String isbn;
    private String title;
    private String author;
    private String price;
    private String amount;
    private String type;
    private String length;
    private String pHouse;
    private String year;

    public Book(String isbn, String author, String title, String price, String amount, String type, String length, String pHouse, String year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
        this.amount = amount;
        this.type = type;
        this.length = length;
        this.pHouse = pHouse;
        this.year = year;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getpHouse() {
        return pHouse;
    }

    public void setpHouse(String pHouse) {
        this.pHouse = pHouse;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


    @Override
    public String toString() {
        return author+"  ,,"+title+"'' ";
    }

    public String info(){
        return isbn+"\n"+author+"\n"+"  ,,"+title+"'' "+"\n"+price+" zl "+"\n"+"W magazynie jest "+amount+" książek."
                +"\n"+"Dlugosc "+ length+" stron"+"\n"+"Gatunek "+type+"\n"+pHouse+", "+year;
    }
}
