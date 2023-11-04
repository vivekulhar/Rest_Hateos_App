package dev.vivek.rest_hateos_app.controller;

import dev.vivek.rest_hateos_app.bindings.Book;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
public class BookRestControllers {
    @GetMapping(value="/book/{isbn}", produces = "application/json")
    public Book getBookInfo(@PathVariable String isbn){
        Book b = new Book(isbn, "The Alchemist", "Paulo Coelho", 399.00);

        Link withRel = WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(BookRestControllers.class)
                                .getAllBooks())
                .withRel("All-Books");

        b.add(withRel);
        return b;
    }
    @GetMapping(value="/books", produces = "application/json")
    public List<Book> getAllBooks(){
        List<Book> list = new ArrayList<>();
        list.add(new Book("978-0061122415", "To Kill a Mockingbird", "Harper Lee", 8.99));
        list.add(new Book("978-0451524935", "1984", "George Orwell", 7.99));
        list.add(new Book("978-0618260300", "The Hobbit", "J.R.R. Tolkien", 9.99));
        list.add(new Book("978-0743273565", "The Catcher in the Rye", "J.D. Salinger", 7.99));
        return list;
    }
}
