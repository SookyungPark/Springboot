package com.example.day08PracConvert;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Controller
public class ItemController {

    @GetMapping("/itemForm")
    //최초의 폼화면 요청시
    //Item 타입의 빈객체를 생성하고 모델에 저장해준다
    //모델키의 이름은 Type의 첫글자 소문자 규칙을 가진다
    //

    public String itemForm(@ModelAttribute Item item){
        return "itemForm";
    }

    @PostMapping("/item")
    public String item(@ModelAttribute Item item, BindingResult bindingResult){

        log.info( "bindingResult ={}" , bindingResult);
        log.info( "item ={}" , item);


        //무조건 성공됐다생각하고 리다이렉트
        //return "redirect:/home";
        return "itemForm";

    }

    //날짜를  2025-05-23 으로 다시 입력해 보자 !! 오류가 발생되는것을 확인하자

    //날짜를  2025-05-23 형식으로 받고 싶다면
    //InitBinder사용해서
    //initBinder에 등록해야 한다
    //initBinder의 위치는 controller안에 위치한다
    //컨버터 등록하기

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        //날짜
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

}
