package com.hellozo0.CICD_TEST.dto.response.best;



import com.hellozo0.CICD_TEST.domain.Book;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Schema(description = "베스트 도서 응답DTO")
@Getter
public class BestBookResponse{

    private Long bookId;

    private String imgUrl;

    private String title;

    private String subtitle;

    private String writer;

    private String painter;

    private String publisher;

    private String pubDate;

    private double score;

    private int tag;

    private String discountPrice;

    private String mileage;

    private boolean heart;


    public BestBookResponse() {}

    public BestBookResponse(Book book, Boolean heartStatus) {
        this.bookId = book.getId();
        this.imgUrl = book.getImg();
        this.title = book.getTitle();
        this.subtitle = book.getSubTitle();
        this.writer = book.getWriter();
        this.painter = book.getPainter();
        this.publisher = book.getPublisher();
        this.pubDate = toDatePattern(book.getPubDate());
        this.score = book.getScore();
        this.tag = book.getTag();
        this.discountPrice = toDiscountPrice(book.getPrice());
        this.mileage = toMileage(book.getMileage());
        this.heart = heartStatus;
    }

    private String toDatePattern(LocalDateTime date){
        return date.format(DateTimeFormatter.ofPattern("yyyy년 MM월"));
    }

    private String toDiscountPrice(int price){
        price = (int) Math.ceil(price * 0.9);
        String won = Integer.toString(price);
        return won.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",") + "원";
    }

    private String toMileage(int price){
        String won = Integer.toString(price);
        return won.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",") + "원";
    }

}
