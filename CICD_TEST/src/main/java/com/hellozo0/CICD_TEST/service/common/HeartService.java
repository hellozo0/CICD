package com.hellozo0.CICD_TEST.service.common;



import com.hellozo0.CICD_TEST.domain.Book;
import com.hellozo0.CICD_TEST.domain.Heart;
import com.hellozo0.CICD_TEST.repository.BookJpaRepository;
import com.hellozo0.CICD_TEST.repository.HeartJpaRepository;
import com.hellozo0.CICD_TEST.util.error.BadRequestException;
import com.hellozo0.CICD_TEST.util.error.ErrorResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HeartService {

    private final HeartJpaRepository heartJpaRepository;
    private final BookJpaRepository bookJpaRepository;

    @Transactional
    public String clickHeart(int bookId){
        Book book = bookJpaRepository.findById(Long.valueOf(bookId)).orElseThrow(() -> new BadRequestException(ErrorResponseStatus.BAD_REQUEST_MISSING_VALUE));  //book 조회

        if(heartJpaRepository.existsByBook_Id(bookId) == true){
            Heart heart = heartJpaRepository.findByBook(book);
            heartJpaRepository.delete(heart);
            return "좋아요 취소";
        } else {
            Heart heart = new Heart(book);
            heartJpaRepository.save(heart);
            return "좋아요 저장";
        }

    }

}
