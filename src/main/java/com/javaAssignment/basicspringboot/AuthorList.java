package com.javaAssignment.basicspringboot;

import com.javaAssignment.basicspringboot.Model.Author;
import com.javaAssignment.basicspringboot.Repository.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AuthorList implements CommandLineRunner {
    private final AuthorRepository authorRepository;

    public AuthorList(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) {
        Author author1 = new Author("Harper Lee");
        Author author2 = new Author("Kobe Bryant");
//        authorRepository.save(author1);
//        authorRepository.save(author2);

    }
}
