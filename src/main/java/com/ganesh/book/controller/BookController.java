package com.ganesh.book.controller;

import com.ganesh.book.dto.BookDto;
import com.ganesh.book.dto.CreateBookRequestDto;
import com.ganesh.book.dto.UpdateBookRequestDto;
import com.ganesh.book.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks() {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBooks());
    }

    @PostMapping
    public ResponseEntity<BookDto> addNewBook(@RequestBody @Valid CreateBookRequestDto createBookRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.addNewBook(createBookRequestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable Long id, @RequestBody @Valid UpdateBookRequestDto updateBookRequestDto) {
        return ResponseEntity.ok(bookService.updateBook(id, updateBookRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return ResponseEntity.noContent().build();
    }
}
