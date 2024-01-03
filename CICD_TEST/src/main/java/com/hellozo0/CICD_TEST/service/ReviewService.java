package com.hellozo0.CICD_TEST.service;


import com.hellozo0.CICD_TEST.domain.Book;
import com.hellozo0.CICD_TEST.domain.Review;
import com.hellozo0.CICD_TEST.dto.request.review.ReviewRequest;
import com.hellozo0.CICD_TEST.repository.BookJpaRepository;
import com.hellozo0.CICD_TEST.repository.ReviewJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewService {

    private final ReviewJpaRepository reviewJpaRepository;
    private final BookJpaRepository bookJpaRepository;

    public void createReview(ReviewRequest reviewRequest){
        Book book = bookJpaRepository.findByIdOrThrow(reviewRequest.bookId());
        Review review = reviewJpaRepository.save(
                Review.builder()
                        .book(book)
                        .score(reviewRequest.score())
                        .content(reviewRequest.content())
                .build()
        );
    }

}
