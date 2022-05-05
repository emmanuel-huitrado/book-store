package coe.unosquare.bookstore.service;

import coe.unosquare.bookstore.dto.BookDTO;
import coe.unosquare.bookstore.entities.Book;
import coe.unosquare.bookstore.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }

    public Book findBookById(Long id) throws NoSuchElementException {
        return bookRepository.findById(id).orElseThrow();
    }

    public Book saveBook(BookDTO book){
        Book newBook = modelMapper.map(book, Book.class);
        return bookRepository.saveAndFlush(newBook);
    }

    public Long deleteBookById(Long id){
        bookRepository.deleteById(id);
        return id;
    }
}
