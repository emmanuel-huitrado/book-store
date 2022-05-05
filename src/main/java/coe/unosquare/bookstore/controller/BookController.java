package coe.unosquare.bookstore.controller;

import coe.unosquare.bookstore.dto.BookDTO;
import coe.unosquare.bookstore.entities.Book;
import coe.unosquare.bookstore.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/books")
@AllArgsConstructor
public class BookController {
    public final BookService bookService;

    @GetMapping("/id/{id}")
    public Book getBookById(@PathVariable Long id){
        return bookService.findBookById(id);
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.findAllBooks();
    }

    @PostMapping
    public Book saveBook(@RequestBody BookDTO book){
        return bookService.saveBook(book);
    }

    @DeleteMapping
    public Long deleteBook(@RequestAttribute Long id){
        return bookService.deleteBookById(id);
    }
}
