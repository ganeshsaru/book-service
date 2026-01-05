package com.ganesh.book.service;

import com.ganesh.book.dto.BookDto;
import com.ganesh.book.dto.CreateBookRequestDto;
import com.ganesh.book.dto.UpdateBookRequestDto;
import com.ganesh.book.entity.BookEntity;
import com.ganesh.book.mapper.BookMapper;
import com.ganesh.book.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<BookEntity> books = bookRepository.findAll();
        return books
                .stream()
                .map(book -> bookMapper.toDto(book))
                .toList();
    }

    @Override
    public BookDto getBookById(Long id) {
        BookEntity book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book not found with ID" + id));
        return bookMapper.toDto(book);
    }

    @Override
    public BookDto addNewBook(CreateBookRequestDto createBookRequestDto) {
        BookEntity newBook = bookMapper.toEntity(createBookRequestDto);
        BookEntity savedBook = bookRepository.save(newBook);
        return bookMapper.toDto(savedBook);
    }

    @Override
    public BookDto updateBook(Long id, UpdateBookRequestDto updateBookRequestDto) {
        BookEntity book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book not found with ID" + id));
        bookMapper.updateEntity(book, updateBookRequestDto);
        BookEntity updatedBook = bookRepository.save(book);
        return bookMapper.toDto(updatedBook);
    }

    @Override
    public void deleteBookById(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new IllegalArgumentException("Book does not exists by ID" + id);
        }
        bookRepository.deleteById(id);
    }
}
