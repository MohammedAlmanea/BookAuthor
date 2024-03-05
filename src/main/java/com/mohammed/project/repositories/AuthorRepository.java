package com.mohammed.project.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mohammed.project.domain.AuthorEntity;





@Repository
public interface AuthorRepository extends CrudRepository<AuthorEntity,UUID> {

}
