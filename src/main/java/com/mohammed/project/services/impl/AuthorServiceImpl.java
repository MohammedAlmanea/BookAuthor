package com.mohammed.project.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.mohammed.project.domain.AuthorEntity;
import com.mohammed.project.repositories.AuthorRepository;
import com.mohammed.project.services.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService{

    private AuthorRepository authorRepository;

    
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public AuthorEntity save(AuthorEntity author) {
        return authorRepository.save(author);
    }


    @Override
    public List<AuthorEntity> findAll() {
        return StreamSupport.stream(
            authorRepository.findAll().spliterator(),
             false
             ).collect(Collectors.toList());
    }


    @Override
    public Optional<AuthorEntity> findOne(UUID id) {
        return authorRepository.findById(id);
    }


    @Override
    public boolean isExists(UUID id) {
        return authorRepository.existsById(id);
    }

    

}
