package com.ganesh.book.service;

import com.ganesh.book.dto.BookDto;
import com.ganesh.book.dto.CreateBookRequestDto;
import com.ganesh.book.dto.UpdateBookRequestDto;

import java.util.List;

public interface BookService {
    List<BookDto> getAllBooks();

    BookDto getBookById(Long id);

    BookDto addNewBook(CreateBookRequestDto createBookRequestDto);

    BookDto updateBook(Long id, UpdateBookRequestDto updateBookRequestDto);

    void deleteBookById(Long id);
}
