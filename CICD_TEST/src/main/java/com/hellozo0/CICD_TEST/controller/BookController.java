package com.hellozo0.CICD_TEST.controller;


import com.hellozo0.CICD_TEST.dto.response.book.BookDetailResponse;
import com.hellozo0.CICD_TEST.dto.response.main.EditorChoiceResponse;
import com.hellozo0.CICD_TEST.service.BookService;
import com.hellozo0.CICD_TEST.util.BaseApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "BookController")
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @Operation(summary = "도서 상세페이지 조회", description = "도서 상세페이지 조회 API입니다.")
    @Parameter(name = "bookId", description = "도서 고유 id값")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "도서 상세 정보 불러오기 완료", content = @Content(schema = @Schema(implementation = EditorChoiceResponse.class))),
    })
    @GetMapping(value = "/{bookId}")
    public BaseApiResponse<BookDetailResponse> getBookDetails(@PathVariable Long bookId){
        return new BaseApiResponse<>("도서 상세 정보 불러오기 완료", bookService.getBookDetails(bookId));
    }

}
