package com.pluralsight;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    public Book(){}

    public Book(int id, String isbn, String title, boolean isCheckedOut, String checkedOutTo){
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = isCheckedOut;
        this.checkedOutTo = checkedOutTo;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getIsbn(){
        return isbn;
    }
    public void setIsbn(String isbn){
        this.isbn = isbn;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setCheckedOut(boolean checkedOut){
        isCheckedOut = checkedOut;
    }
    public boolean isItCheckedOut(){
        return isCheckedOut;
    }
    public String getCheckedOutTo(){
        return checkedOutTo;
    }
    public void setCheckedOutTo(String checkedOutTo){
        this.checkedOutTo = checkedOutTo;
    }
    public void checkOut(String name){
        checkedOutTo = name;
        isCheckedOut = true;
    }
    public void checkIn(){
        checkedOutTo = "";
        isCheckedOut = false;
    }
    public String availableBooks() {
        return "Book: " +
                "\nid: " + id +
                "\nisbn: " + isbn  +
                "\nTitle: " + title  + "\n\n";
    }
    public String checkedOutBooks() {
        return "Book: " +
                "\nid: " + id +
                "\nisbn: " + isbn  +
                "\nTitle: " + title  + "\nBook Checked out to: " +
                checkedOutTo
                + "\n\n";
    }
}
