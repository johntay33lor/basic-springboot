package com.javaAssignment.basicspringboot.Controller;

import com.javaAssignment.basicspringboot.Model.Author;
import com.javaAssignment.basicspringboot.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("")
    public String showAuthorList(Model model) {
        List<Author> authors = authorRepository.findAll();
        model.addAttribute("authors", authors);
        return "author-list";
    }

    @GetMapping("/details/{id}")
    public String getAuthorById(@PathVariable("id") Long id, Model model) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid author id: " + id));
        model.addAttribute("author", author);
        return "author-list";
    }

    @GetMapping("/add")
    public String showAddAuthorForm(Model model) {
        model.addAttribute("author", new Author());
        return "author-add";
    }

    @PostMapping("/add")
    public String addAuthor(@ModelAttribute("author") @Validated Author author, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "author-add";
        }

        authorRepository.save(author);
        return "redirect:/authors";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid author id: " + id));
        model.addAttribute("author", author);
        return "author-update";
    }

    @PostMapping("/edit/{id}")
    public String editAuthor(@PathVariable("id") Long id, @ModelAttribute("author") @Validated Author updatedAuthor, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "author-update";
        }
            Author author = authorRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid author id: " + id));

            author.setName(updatedAuthor.getName());
            authorRepository.save(author);

            return "redirect:/authors";
        }

        @GetMapping("/delete/{id}")
        public String deleteAuthor (@PathVariable("id") Long id){
            authorRepository.deleteById(id);
            return "redirect:/authors";
        }
    }
