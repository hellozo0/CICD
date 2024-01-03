package com.hellozo0.CICD_TEST.controller;


import com.hellozo0.CICD_TEST.dto.request.review.ReviewRequest;
import com.hellozo0.CICD_TEST.dto.response.main.EditorChoiceResponse;
import com.hellozo0.CICD_TEST.service.ReviewService;
import com.hellozo0.CICD_TEST.util.BaseApiResponseNonData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "ReviewController")
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @Operation(summary = "도서 리뷰 등록", description = "도서 리뷰 등록 API입니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "도서 리뷰 등록 완료", content = @Content(schema = @Schema(implementation = EditorChoiceResponse.class))),
    })
    @PostMapping("")
    public BaseApiResponseNonData createReview(@RequestBody ReviewRequest reviewRequest){
        reviewService.createReview(reviewRequest);
        return new BaseApiResponseNonData("도서 리뷰 등록 완료");
    }

}
