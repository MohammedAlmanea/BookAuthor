package com.mohammed.project.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.mohammed.project.domain.BookEnity;
import com.mohammed.project.repositories.BookRepository;
import com.mohammed.project.services.BookService;

@Service
public class BookServiceImpl implements BookService {
    
    private BookRepository bookRepository;

    
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public BookEnity createBook(BookEnity book) {
        return bookRepository.save(book);
    }


    @Override
    public List<BookEnity> findAll() {
        return StreamSupport.stream(
            bookRepository.findAll().spliterator(),
             false).collect(Collectors.toList());
    }


    @Override
    public Optional<BookEnity> findOne(UUID id) {
        return bookRepository.findById(id);
    }

}
