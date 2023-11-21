package com.bookland.bookservice.service;

import com.bookland.bookservice.dto.BookDto;
import com.bookland.bookservice.dto.BookIdDto;
import com.bookland.bookservice.exception.BookNotFoundException;
import com.bookland.bookservice.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<BookDto> getAllBooks(){

        return  repository.findAll()
                .stream()
                .map(BookDto::convert)
                .collect(Collectors.toList());
    }

    public BookIdDto findByIsbn(String isbn){
        return repository.findBookByIsbn(isbn)
                .map(book ->  new BookIdDto(book.getId(), book.getIsbn()))
                .orElseThrow(()-> new BookNotFoundException("Book couldnt find by isbn"));
    }
}
