package com.mohammed.project.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.mohammed.project.domain.AuthorEntity;

public interface AuthorService {
    AuthorEntity save(AuthorEntity author);

    List<AuthorEntity> findAll();

    Optional<AuthorEntity> findOne(UUID id);

    boolean isExists(UUID id);
}
