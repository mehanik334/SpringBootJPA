package com.study.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "book")
@Data
public class Book {

    @Id
    @GeneratedValue
    private Integer id;

    private String title;

    private String author;

    private String genre;

    private double price;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Book() {

    }

    public Book(String title, String author, String genre, double price, User user) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.user = user;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                ", user=" + user.getLogin() +
                '}';
    }
}
