package com.example.day08PracValid;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
public class OrderController {

    @GetMapping("/orderForm")

    //빈 Order 객체를 모델에 저장해줌
    //orderForm form -> th:object에서 폼과 order 객체 바인딩이 오류없이 됨
    public String orderForm(@ModelAttribute Order order){   //주의 꼭 넣어줘야 함
        return "orderForm";
    }

    @PostMapping ("/order")
    public String order(@ModelAttribute Order order, Model model){
        log.info( "order ={}" , order);

        //order 객체 검증하기
        //검증 후 에러정보를 담을 객체 생성하기
        Map<String, String> errors = new HashMap<>();

        //이름 검증
        //String str = null, String str=""
        if(order.getName()==null || order.getName().isEmpty()){
            errors.put("name", "상품이름을 입력하세요.");
        }

        //금액검증 100 ~ 10,000
        if(order.getPrice()==null || order.getPrice()<100 || order.getPrice()>10000){
            errors.put("price","상품금액은 100~10,000이어야 한다.");
        }

        //수량검증
        if(order.getQty()==null || order.getQty()>999){
            errors.put("qty", "수량은 999 초과 불가능");
        }


        //실패 => 다시 폼으로, 오류메세지 출력
        //성공 => 서비스실행, 홈화면

        if(!errors.isEmpty()){  //에러가 있으면

            log.info( "errors ={}" , errors);
            model.addAttribute("errors", errors);
            return "orderForm";
        }

        //return "orderForm";

        //에러가 없는 경우
        return "redirect:/home";
    }

}
