package com.hellozo0.CICD_TEST.util;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BaseApiResponse<T> {

    @Schema(example = "상태 코드")
    private Integer status;

    @Schema(example =  "성공 여부")
    private Boolean success;

    @Schema(example =  "상태 메세지")
    private String message;

    @Schema(example =  "전달할 데이터")
    private T data;

    public BaseApiResponse(String message, T data){
        this.status = HttpStatus.OK.value();
        this.success = true;
        this.message = message;
        this.data = data;
    }
}
