package com.hellozo0.CICD_TEST.controller;



import com.hellozo0.CICD_TEST.service.common.HeartService;
import com.hellozo0.CICD_TEST.util.BaseApiResponseNonData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "HeartController")
@RequestMapping("/heart")
@RequiredArgsConstructor
public class HeartController {

    private final HeartService heartService;

    @Operation(summary = "책 좋아요/취소", description = "책 좋아요/취소 기능 API입니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "책 좋아요/취소 기능 처리 완료"),
            @ApiResponse(responseCode = "400", description = "유효한 책 id를 보냈는지 확인해주세요.")
    })
    @PostMapping()
    public BaseApiResponseNonData postSaveHeartStatus(@RequestParam("bookId")int bookId){
        return new BaseApiResponseNonData(heartService.clickHeart(bookId));
    }
}
