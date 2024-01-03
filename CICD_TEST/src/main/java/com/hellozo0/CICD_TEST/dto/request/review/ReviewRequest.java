package com.hellozo0.CICD_TEST.dto.request.review;

public record ReviewRequest(
        Long bookId,
        double score,
        String content
) {
}
