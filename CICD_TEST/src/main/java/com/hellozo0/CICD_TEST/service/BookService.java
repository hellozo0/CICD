package com.hellozo0.CICD_TEST.service;


import com.hellozo0.CICD_TEST.domain.Book;
import com.hellozo0.CICD_TEST.dto.response.book.BookDetailResponse;
import com.hellozo0.CICD_TEST.repository.BookJpaRepository;
import com.hellozo0.CICD_TEST.repository.HeartJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookService {

    private final BookJpaRepository bookJpaRepository;
    private final HeartJpaRepository heartJpaRepository;


    public BookDetailResponse getBookDetails(Long bookId){
        Book book = bookJpaRepository.findByIdOrThrow(bookId);
        boolean isHearted = heartJpaRepository.existsByBook_Id(bookId);

        return new BookDetailResponse(
                book.getId(),
                book.getImg(),
                book.getTitle(),
                book.getSubTitle(),
                book.getWriter(),
                book.getPainter(),
                book.getPublisher(),
                toDatePattern(book.getPubDate()),
                book.getScore(),
                book.getTag(),
                toDiscountPrice(book.getPrice()),
                toOriginPrice(book.getPrice()),
                toMileage(book.getMileage()),
                isHearted
        );
    }

    private String toDatePattern(LocalDateTime date) {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    private String toDiscountPrice(int price){
        price = (int) Math.ceil(price * 0.9);
        String won = Integer.toString(price);
        return won.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",") + "원";
    }

    private String toOriginPrice(int price){
        String won = Integer.toString(price);
        return won.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",") + "원";
    }

    private String toMileage(int price){
        String won = Integer.toString(price);
        return won.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",") + "원";
    }
}
