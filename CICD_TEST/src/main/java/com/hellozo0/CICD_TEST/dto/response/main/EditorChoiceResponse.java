package com.hellozo0.CICD_TEST.dto.response.main;

import com.hellozo0.CICD_TEST.domain.Book;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "편집장의 선택 응답DTO")
public record EditorChoiceResponse(
        Long id,
        String imgUrl,
        String title,
        String subtitle,
        String description
) {
    public static EditorChoiceResponse of(Book book) {
        return new EditorChoiceResponse(
                book.getId(),
                book.getImg(),
                book.getTitle(),
                book.getSubTitle(),
                book.getDescription()
        );
    }
}
