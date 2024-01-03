package com.hellozo0.CICD_TEST.repository;

import com.hellozo0.CICD_TEST.domain.Book;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookJpaRepository extends JpaRepository<Book, Long> {

    default Book findByIdOrThrow(Long bookId){
        return findById(bookId)
                .orElseThrow(()-> new EntityNotFoundException("해당하는 책이 없습니다."));
    }
}
