package com.javaAssignment.basicspringboot.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Enter a title")
    @Size(min=2, max=100)
    private String title;

    @ManyToOne
    private Author author;

    public Book() {
    }

    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    // Getters and setters
    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }
    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }


    public Author getAuthor() {

        return author;
    }

    public void setAuthor(Author author) {

        this.author = author;
    }

}
