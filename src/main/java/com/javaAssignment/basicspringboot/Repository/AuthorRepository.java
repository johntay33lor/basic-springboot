package com.javaAssignment.basicspringboot.Repository;

import com.javaAssignment.basicspringboot.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
