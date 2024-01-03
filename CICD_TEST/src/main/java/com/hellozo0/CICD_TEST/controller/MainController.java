package com.hellozo0.CICD_TEST.controller;



import com.hellozo0.CICD_TEST.dto.response.main.EditorChoiceResponse;
import com.hellozo0.CICD_TEST.service.MainService;
import com.hellozo0.CICD_TEST.util.BaseApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "MainController")
@RequestMapping("/main")
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;

    @Operation(summary = "편집장의 선택 조회", description = "편집장의 선택 정보 불러오기 API입니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "편집장의 선택 목록 불러오기 완료", content = @Content(schema = @Schema(implementation = EditorChoiceResponse.class))),
    })
    @GetMapping("/editorchoice")
    public BaseApiResponse<Object> getEditorChoice(){
        return new BaseApiResponse<>("편집장의 선택 목록 불러오기 완료", mainService.getEditorChoice());
    }
}
