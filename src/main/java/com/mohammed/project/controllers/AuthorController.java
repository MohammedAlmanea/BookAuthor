package com.mohammed.project.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.mohammed.project.domain.AuthorEntity;
import com.mohammed.project.domain.dto.AuthorDTO;
import com.mohammed.project.mappers.Mapper;
import com.mohammed.project.services.AuthorService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
public class AuthorController {

    private AuthorService authorService;
    private Mapper<AuthorEntity, AuthorDTO> authorMapper;

    

    public AuthorController(AuthorService authorService, Mapper<AuthorEntity, AuthorDTO> authorMapper) {
        this.authorService = authorService;
        this.authorMapper = authorMapper;
    }



    @PostMapping(path = "/authors")
    public AuthorDTO createAuthor(@RequestBody AuthorDTO author) {
        AuthorEntity authorEntity = authorMapper.mapFrom(author);
        AuthorEntity savedAuthorEntity = authorService.save(authorEntity);
        return authorMapper.mapTo(savedAuthorEntity);
    }

    @GetMapping(path = "/authors")
    public List<AuthorDTO> listAuthors() {
        List<AuthorEntity> authors = authorService.findAll();
        return authors.stream().map(authorMapper:: mapTo).collect(Collectors.toList());
        
    }

    @GetMapping(path = "/authors/{id}")
    public ResponseEntity<AuthorDTO> getAuthor(@PathVariable("id") UUID id) {
        Optional<AuthorEntity> foundAuthor = authorService.findOne(id);
       return foundAuthor.map(authorEntity -> {
            AuthorDTO authorDto = authorMapper.mapTo(authorEntity);
            return new ResponseEntity<>(authorDto, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @PutMapping("/authors/{id}")
    public ResponseEntity<AuthorDTO> fullUpdateAuthor(@PathVariable("id") UUID id, @RequestBody AuthorDTO author) {

        if (!authorService.isExists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        author.setId(id);
        AuthorEntity authorEntity = authorMapper.mapFrom(author);
        AuthorEntity savedAuthorEntity = authorService.save(authorEntity);
        return new ResponseEntity<>(authorMapper.mapTo(savedAuthorEntity),HttpStatus.OK);
    }
    
    
}
