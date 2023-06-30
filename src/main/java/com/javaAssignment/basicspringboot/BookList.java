package com.javaAssignment.basicspringboot;

import com.javaAssignment.basicspringboot.Model.Book;
import com.javaAssignment.basicspringboot.Model.Author;
import com.javaAssignment.basicspringboot.Repository.AuthorRepository;
import com.javaAssignment.basicspringboot.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BookList implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Autowired
    public BookList(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {
        Author author1 = new Author("Harper Lee");
        Author author2 = new Author("Kobe Bryant");
        authorRepository.save(author1);
        authorRepository.save(author2);

        Book book1 = new Book("To Kill a Mockingbird", author1);
        Book book2 = new Book("The Mamba Mentality", author2);
        bookRepository.save(book1);
        bookRepository.save(book2);
    }
}
