/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author hoangduongngg
 */
public class Book {
    private String bookcode;
    private String title;
    private String author ;
    private String category ;
    private Integer booked ;

    public Book() {
    }

    public Book(String bookcode, String title, String author, String category, Integer booked) {
        this.bookcode = bookcode;
        this.title = title;
        this.author = author;
        this.category = category;
        this.booked = booked;
    }

    public String getBookcode() {
        return bookcode;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public Integer getBooked() {
        return booked;
    }

    public void setBookcode(String bookcode) {
        this.bookcode = bookcode;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setBooked(Integer booked) {
        this.booked = booked;
    }

    @Override
    public String toString() {
        return "Book{" + "bookcode=" + bookcode + ", title=" + title + ", author=" + author + ", category=" + category + ", booked=" + booked + '}';
    }
    
    
}
