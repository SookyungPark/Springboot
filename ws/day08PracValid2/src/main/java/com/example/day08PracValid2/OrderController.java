package com.example.day08PracValid2;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class OrderController {

    @GetMapping("/orderForm")

    //폼 화면에서 form - 모델객체 바인딩을 위해서 빈 객체를 모델로 제공해야함
    public String orderForm(@ModelAttribute  Order order){
        return "orderForm";
    }

    //검증하려면
    //1. 검증하려면 객체 뒤에 BindingResult bindingResult
    //2. 검증객체 작성하기 (Validator 인터페이스를 구현해야한다), 에러코드만들기
    //3. 검증하는 객체 앞에 @Validated 붙여야한다
    //4. 오류메세지 등록하기(에러코드에 대한 에러메세지 작성하기)
    //5. 뷰에 에러가 있는 필드는 에러메세지가 나올수있게한다
    //6. validator 등록하기


    @PostMapping("/order")
    public String  order(@ModelAttribute @Validated Order order, BindingResult bindingResult){

        log.info( "item ={}" , order);

        if(bindingResult.hasErrors()){
            log.info("bindingResult={}", bindingResult);
            return "orderForm";
        }



        return "redirect:/home";
    }


}
