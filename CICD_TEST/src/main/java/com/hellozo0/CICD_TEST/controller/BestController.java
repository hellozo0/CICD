package com.hellozo0.CICD_TEST.controller;



import com.hellozo0.CICD_TEST.dto.response.best.BestBookResponse;
import com.hellozo0.CICD_TEST.service.BestService;
import com.hellozo0.CICD_TEST.util.BaseApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "BestController")
@RequestMapping("/best")
@RequiredArgsConstructor
public class BestController {

    private final BestService bestService;

    @Operation(summary = "BEST 책 리스트 조회", description = "BEST 책 리스트 정보 불러오기 API입니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "BEST 책 리스트 불러오기 완료", content = @Content(schema = @Schema(implementation = BestBookResponse.class))),
    })
    @GetMapping()
    public BaseApiResponse<Object> getEditorChoice(){
        return new BaseApiResponse<>("BEST 책 리스트 불러오기 완료", bestService.getBestBookList());


    }
}
