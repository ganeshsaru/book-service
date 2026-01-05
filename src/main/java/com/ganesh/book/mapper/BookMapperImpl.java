package com.ganesh.book.mapper;

import com.ganesh.book.dto.BookDto;
import com.ganesh.book.dto.BookRequest;
import com.ganesh.book.entity.BookEntity;
import org.springframework.stereotype.Component;

@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public BookDto toDto(BookEntity bookEntity) {
        if (bookEntity == null) return null;
        BookDto bookDto = new BookDto();
        bookDto.setId(bookEntity.getId());
        bookDto.setTitle(bookEntity.getTitle());
        bookDto.setAuthor(bookEntity.getAuthor());
        bookDto.setIsbn(bookEntity.getIsbn());
        return bookDto;
    }

    @Override
    public BookEntity toEntity(BookDto bookDto) {
        if (bookDto == null) return null;
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(bookDto.getId());
        bookEntity.setTitle(bookDto.getTitle());
        bookEntity.setAuthor(bookDto.getAuthor());
        bookEntity.setIsbn(bookDto.getIsbn());
        return bookEntity;
    }

    @Override
    public BookEntity toEntity(BookRequest bookRequest) {
        if (bookRequest == null) return null;
        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle(bookRequest.getTitle());
        bookEntity.setAuthor(bookRequest.getAuthor());
        bookEntity.setIsbn(bookRequest.getIsbn());
        return bookEntity;
    }

    @Override
    public void updateEntity(BookEntity bookEntity, BookRequest bookRequest) {
        if (bookEntity == null || bookRequest == null) return;
        bookEntity.setTitle(bookRequest.getTitle());
        bookEntity.setAuthor(bookEntity.getAuthor());
        bookEntity.setIsbn(bookRequest.getIsbn());
    }

}
