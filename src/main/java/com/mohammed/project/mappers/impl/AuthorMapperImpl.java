package com.mohammed.project.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.mohammed.project.domain.AuthorEntity;
import com.mohammed.project.domain.dto.AuthorDTO;
import com.mohammed.project.mappers.Mapper;

@Component
public class AuthorMapperImpl implements Mapper<AuthorEntity, AuthorDTO> {


    private ModelMapper modelMapper;

    public AuthorMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public AuthorDTO mapTo(AuthorEntity a) {
        return modelMapper.map(a,AuthorDTO.class);
    }

    @Override
    public AuthorEntity mapFrom(AuthorDTO b) {
        return modelMapper.map(b , AuthorEntity.class);
    }

}
