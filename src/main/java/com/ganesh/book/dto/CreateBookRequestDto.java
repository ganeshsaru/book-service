package com.ganesh.book.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateBookRequestDto implements BookRequest{
    @NotBlank
    @Size(min = 3, max = 100)
    private String title;

    @NotBlank
    @Size(min = 3, max = 100)
    private String author;

    @NotBlank
    @Size(min = 1, max = 50)
    private String isbn;
}
