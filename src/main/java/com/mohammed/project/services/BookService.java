package com.mohammed.project.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.mohammed.project.domain.BookEnity;

public interface BookService {
    BookEnity createBook(BookEnity book);

    List<BookEnity> findAll();

    Optional<BookEnity> findOne(UUID id);
}
