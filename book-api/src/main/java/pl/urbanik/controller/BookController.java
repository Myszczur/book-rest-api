package pl.urbanik.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.urbanik.model.Book;
import pl.urbanik.service.BookService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/book")
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/book/{id}")
    public Book findById(@PathVariable Long id) {
        return bookService.findById(id).orElse(null);
    }

    @PostMapping("/book")
    public Book create(@RequestBody Book book) {
        return bookService.create(book);
    }

    @PutMapping("/book/{id}")
    public Book update(@PathVariable Long id, @RequestBody Book book) {
        return bookService.update(id, book);
    }

    @DeleteMapping("/book/{id}")
    public boolean delete(@PathVariable Long id) {
        return bookService.delete(id);
    }
}
