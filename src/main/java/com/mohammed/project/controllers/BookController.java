package com.mohammed.project.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mohammed.project.domain.BookEnity;
import com.mohammed.project.domain.dto.BookDTO;
import com.mohammed.project.mappers.Mapper;
import com.mohammed.project.services.BookService;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
public class BookController {
    
    private BookService bookService;
    private Mapper<BookEnity,BookDTO> bookMapper;
    public BookController(BookService bookService, Mapper<BookEnity, BookDTO> bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @PostMapping(path = "/books")
    public BookDTO createBook(@RequestBody BookDTO bookDTO) {
        BookEnity bookEnity = bookMapper.mapFrom(bookDTO);
        BookEnity savedBook = bookService.createBook(bookEnity);
        return bookMapper.mapTo(savedBook);
    }

    @GetMapping(path = "/books")
    public List<BookDTO> listBooks() {
        List<BookEnity> books = bookService.findAll();
        return books.stream().map(bookMapper::mapTo).collect(Collectors.toList());
    }

    @GetMapping(path = "/books/{id}")
    public ResponseEntity<BookDTO> getBook(@PathVariable("id") UUID id) {
        Optional<BookEnity> foundBook = bookService.findOne(id);
        return foundBook.map(bookEnity -> {
            BookDTO bookDto = bookMapper.mapTo(bookEnity);
            return new ResponseEntity<>(bookDto, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    
}
