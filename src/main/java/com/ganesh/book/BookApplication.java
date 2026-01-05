package com.ganesh.book;

import com.ganesh.book.mapper.BookMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookApplication {

	public static void main(String[] args) {

        SpringApplication.run(BookApplication.class, args);
	}
}
