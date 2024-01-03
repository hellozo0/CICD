package com.hellozo0.CICD_TEST.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "review")
public class Review extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    private double score;

    @Column(columnDefinition = "TEXT")
    private String content;


    @Builder
    public Review(Book book, double score, String content){
        this.book = book;
        this.score = score;
        this.content = content;
    }

}
