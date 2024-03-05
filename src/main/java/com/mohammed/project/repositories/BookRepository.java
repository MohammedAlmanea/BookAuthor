package com.mohammed.project.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mohammed.project.domain.BookEnity;

@Repository
public interface BookRepository extends CrudRepository<BookEnity,UUID> {

}
