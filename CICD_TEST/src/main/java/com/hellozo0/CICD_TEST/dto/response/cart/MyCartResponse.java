package com.hellozo0.CICD_TEST.dto.response.cart;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "내 장바구니 목록 응답DTO")
public record MyCartResponse(

        Long id,
        String imgUrl,
        String title,
        String subtitle,
        int tag,
        String discountPrice,
        String mileage,
        boolean heart,
        int count

) {
}
