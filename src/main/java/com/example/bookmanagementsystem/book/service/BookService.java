package com.example.bookmanagementsystem.book.service;

import com.example.bookmanagementsystem.book.entity.BookEntity;
import com.example.bookmanagementsystem.book.repo.BookRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BookService {
    private final BookRepo bookRepo;

    @Transactional
    public Long saveBook(BookEntity bookEntity) {
        return bookRepo.save(bookEntity).getId();
    }

    public List<BookEntity> findAllBooks() {
        return bookRepo.findAll();
    }

    public BookEntity findOne(Long id) {
        return bookRepo.findById(id).orElseThrow(
                () -> new IllegalArgumentException("not found book ::" + id)
        );
    }

    @Transactional
    public void deleteBook(Long id) {
        bookRepo.deleteById(id);
    }
}
