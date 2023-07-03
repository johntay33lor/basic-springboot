package com.javaAssignment.basicspringboot.Controller;

import com.javaAssignment.basicspringboot.Model.Author;
import com.javaAssignment.basicspringboot.Model.Book;
import com.javaAssignment.basicspringboot.Repository.AuthorRepository;
import com.javaAssignment.basicspringboot.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookController(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @GetMapping("/add")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book()) ;
        return "book-add";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute("book") @Validated Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "book-add";
        }

        Author author = book.getAuthor();
        authorRepository.save(author);

        String title = book.getTitle();
        book.setTitle(title);

        bookRepository.save(book);
        return "redirect:/books";
    }


    @GetMapping
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "book-list";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book ID: " + id));
        model.addAttribute("book", book);
        return "book-update";
    }

    @PostMapping("/{id}/edit")
    public String editBook(@PathVariable("id") Long id, @ModelAttribute("book") @Validated Book updatedBook, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "book-update";
        }

        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book ID: " + id));

        if (updatedBook.getTitle() != null) {
            book.setTitle(updatedBook.getTitle());
        }

        Author updatedAuthor = updatedBook.getAuthor();
        if (updatedAuthor != null && updatedAuthor.getName() != null) {
            Author author = book.getAuthor();
            author.setName(updatedAuthor.getName());
            authorRepository.save(author);
        }

        bookRepository.save(book);
        return "redirect:/books";
    }
    @GetMapping("/{id}/delete")
    public String deleteBook(@PathVariable("id") Long id) {
        bookRepository.deleteById(id);
        return "redirect:/books";
    }

}
