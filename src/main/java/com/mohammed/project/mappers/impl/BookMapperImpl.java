package com.mohammed.project.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.mohammed.project.domain.BookEnity;
import com.mohammed.project.domain.dto.BookDTO;
import com.mohammed.project.mappers.Mapper;

@Component
public class BookMapperImpl implements Mapper<BookEnity,BookDTO> {

    private ModelMapper modelMapper;

    

    public BookMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public BookDTO mapTo(BookEnity a) {
        return modelMapper.map(a, BookDTO.class);
    }

    @Override
    public BookEnity mapFrom(BookDTO b) {
        return modelMapper.map(b, BookEnity.class);
    }

}
