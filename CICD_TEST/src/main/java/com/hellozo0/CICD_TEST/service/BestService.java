package com.hellozo0.CICD_TEST.service;


import com.hellozo0.CICD_TEST.domain.Book;
import com.hellozo0.CICD_TEST.dto.response.best.BestBookResponse;
import com.hellozo0.CICD_TEST.repository.BookJpaRepository;
import com.hellozo0.CICD_TEST.repository.HeartJpaRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BestService {

    private final BookJpaRepository bookJpaRepository;
    private final HeartJpaRepository heartJpaRepository;

    public List<BestBookResponse> getBestBookList() {

        int count = 0;

        List<Book> books = bookJpaRepository.findAll();

        List<BestBookResponse> bestBookResponseList = new ArrayList<BestBookResponse>();

        for( Book book : books){
            if(count == 10) {
                break;
            }
            BestBookResponse bestBookResponse = new BestBookResponse();
            bestBookResponse = new BestBookResponse(book, heartJpaRepository.existsByBook_Id(book.getId()));

            bestBookResponseList.add(bestBookResponse);
            count++;
        }

        return bestBookResponseList;
    }
}
