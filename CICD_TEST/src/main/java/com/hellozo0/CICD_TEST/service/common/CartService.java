package com.hellozo0.CICD_TEST.service.common;


import com.hellozo0.CICD_TEST.domain.Book;
import com.hellozo0.CICD_TEST.domain.Cart;
import com.hellozo0.CICD_TEST.dto.request.cart.PatchBookNumRequest;
import com.hellozo0.CICD_TEST.dto.response.cart.MyCartResponse;
import com.hellozo0.CICD_TEST.dto.response.common.CountCartResponse;
import com.hellozo0.CICD_TEST.repository.BookJpaRepository;
import com.hellozo0.CICD_TEST.repository.CartJpaRepository;
import com.hellozo0.CICD_TEST.repository.HeartJpaRepository;
import com.hellozo0.CICD_TEST.util.error.BadRequestException;
import com.hellozo0.CICD_TEST.util.error.ErrorResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = false)
public class CartService {

    private final CartJpaRepository cartJpaRepository;
    private final BookJpaRepository bookJpaRepository;
    private final HeartJpaRepository heartJpaRepository;

    public String saveCart(int bookId) {
        Book book = bookJpaRepository.findById(Long.valueOf(bookId)).orElseThrow(() -> new BadRequestException(ErrorResponseStatus.BAD_REQUEST_MISSING_VALUE));

        if(!cartJpaRepository.existsCartByBook_Id(book.getId())){ //Book이 없으면 카트에 저장해야함
            Cart cart = new Cart(book, 1);
            cartJpaRepository.save(cart);
            return "장바구니에 담기 완료.";
        } else { //Book이 있다는 뜻
            return "장바구니에 이미 담겨있습니다.";
        }

    }

    public CountCartResponse countCart(){
        return new CountCartResponse((int) cartJpaRepository.count());
    }

    public List<MyCartResponse> getMyCartLists(){
        List<Cart> carts = cartJpaRepository.findAll();
        return carts.stream()
                .map(this::mapToMyCartResponse)
                .collect(Collectors.toList());
    }

    private MyCartResponse mapToMyCartResponse(Cart cart) {
        Book book = cart.getBook();
        boolean isHearted = heartJpaRepository.existsByBook_Id(book.getId());

        return new MyCartResponse(
                book.getId(),
                book.getImg(),
                book.getTitle(),
                book.getSubTitle(),
                book.getTag(),
                toDiscountPrice(book.getPrice()),
                toMileage(book.getMileage()),
                isHearted,
                cart.getNum()
        );
    }

    @Transactional
    public int patchBookNum(Long bookId, PatchBookNumRequest patchBookNumRequest){
        Book book = bookJpaRepository.findByIdOrThrow(bookId);

        Cart cart = cartJpaRepository.findByBookOrThrow(book);
        cart.setNum(patchBookNumRequest.count());

        return cart.getNum();

    }

    @Transactional
    public String deleteCart(Long bookId){
        Book book = bookJpaRepository.findByIdOrThrow(bookId);

        if(cartJpaRepository.existsCartByBook_Id(book.getId())){ //Book이 카트에 있으면 삭제해야함
            Cart cart = cartJpaRepository.findByBookOrThrow(book);
            cartJpaRepository.delete(cart);
            return "장바구니 도서 삭제 완료";
        } else { //Book이 카트에 없으면 이미 카트에서  삭제된것임
            return "이미 삭제 되었습니다 ";
        }
    }

    private String toDiscountPrice(int price){
        price = (int) Math.ceil(price * 0.9);
        String won = Integer.toString(price);
        return won.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",") + "원";
    }

    private String toMileage(int price){
        String won = Integer.toString(price);
        return won.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",") + "원";
    }


}
