package com.hellozo0.CICD_TEST.repository;

import com.hellozo0.CICD_TEST.domain.Book;
import com.hellozo0.CICD_TEST.domain.Cart;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartJpaRepository extends JpaRepository<Cart, Long> {

    Optional<Cart> findByBook(Book book);

    boolean existsCartByBook_Id(long bookId);

    default Cart findByBookOrThrow(Book book) {
        return findByBook(book)
                .orElseThrow(() -> new EntityNotFoundException("해당 책이 카트에 없습니다."));
    }
}
