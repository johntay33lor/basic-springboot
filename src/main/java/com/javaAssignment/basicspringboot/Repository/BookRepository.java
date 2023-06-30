package com.javaAssignment.basicspringboot.Repository;


import com.javaAssignment.basicspringboot.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
