package com.example.bookmanagementsystem.book.repo;

import com.example.bookmanagementsystem.book.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<BookEntity, Long> {

}
