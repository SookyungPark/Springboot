package com.example.day04Prac;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KakaoController {


    @GetMapping("/kakaoMap")
    public String kakaoMap(){
        return "kakaoMap";
    }





}
