package com.ganesh.book.mapper;

import com.ganesh.book.dto.BookDto;
import com.ganesh.book.dto.BookRequest;
import com.ganesh.book.entity.BookEntity;

public interface BookMapper {
    BookDto toDto(BookEntity bookEntity);
    BookEntity toEntity(BookDto bookDto);
    BookEntity toEntity(BookRequest bookRequest);
    void updateEntity(BookEntity bookEntity, BookRequest bookRequest);
}
