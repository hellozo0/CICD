package com.hellozo0.CICD_TEST.dto.response.common;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Schema(description = "장바구니 개수 응답DTO")
@Getter
public class CountCartResponse {

    private int countCart;

    public CountCartResponse(int countCart) {
        this.countCart = countCart;
    }
}
