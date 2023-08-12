package com.bookstore.entity.entity;
import javax.validation.constraints.Max; import javax.validation.constraints.NotBlank; import lombok.*;
import javax.validation.constraints.Max; import javax.validation.constraints.NotBlank; import lombok.*;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.NotNull; import javax.persistence.*;
import javax.validation.constraints.Min;


@Builder @Setter @Data @Entity @Getter
@Table(name = "book") public class Book {
    public Book() {


        System.out.println("Inside the no argument constructor of book class \n\n");



    }


    @Min(1) @Max(50000)
    @Column(name="BOOK_PRICE", nullable = false) private double bookPrice;

    @NotNull @NotBlank
    @Column(name="BOOK_PUBLISHER_NAME", nullable = false, length=300) private String bookPublisherName;

    @NotNull
    @Min(1)
    @Column(name="BOOK_PAGE_NUM", nullable = false, length=5) @Max(25000)
    private int bookPageNum;


    @NotNull
    @Column(name="BOOK_TITLE",nullable = false, length = 450) @NotBlank
    private String bookTitle;


    @NotNull
    @Column(name="BOOK_AUTHOR", nullable = false, length=400) @NotBlank
    private String bookAuthor;


    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name = “BOOK_ID_NUM”, nullable = false) @Min(1)
    @Max(35000)
    private int bookIdNum;


    @NotBlank
    @Column(name="bookISBNNumber", unique = true, length = 350, nullable = false) @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY) private String bookISBN;

    public void setBookPrice(double bookPrice) {
        if(bookPrice > 0 ) {
          this. bookPrice = bookPrice;
        }
    }
    public String getBookAuthor() {
        return bookAuthor;
    }
    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookAuthor(String author) {
        if(author!= null && author.equalsIgnoreCase(" ") == false) { this. bookAuthor = author;
        }}
    public void setIsbn(String bookISBN) {
        if(bookISBN != null && bookISBN.equalsIgnoreCase(" ") == false) {
            this.bookISBN = bookISBN;
        }}


    public String getBookTitle() {
        return bookTitle;
    }
    public void setBookPublisherName(String bookPublisherName) {
        if(bookPublisherName != null && bookPublisherName.equalsIgnoreCase(" ") == false)
        {
            this. bookPublisherName = bookPublisherName;


        }}


    public int getBookIdNum() {

        return bookIdNum;
    }


    public void setBookIdNum(int bookIdNum) {
        if(bookIdNum > 0) {
          this. bookIdNum = bookIdNum;
        }
    }


    public void setBookTitle(String bookTitle) {
        if(bookTitle != null && bookTitle.equalsIgnoreCase(" ") == false) {
            this. bookTitle = bookTitle;
        }
    }


    public int getBookPageNum() {
        return bookPageNum;

    }
    public String getIsbn() {
        return bookISBN;
    }


    public void setPageNum(int bookPageNum) {
        if(bookPageNum > 0) {
        this. bookPageNum= bookPageNum;
        }
    }

    public void setBookCategory(String bookCategory) {
        if(bookCategory != null && bookCategory.equalsIgnoreCase(" ") == false) {
            this.bookCategory = bookCategory;
        }
    }


    public String getBookPublisherName() { return bookPublisherName;
    }}
