package com.example.day08PracConvert;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

//에이콘 학생 등록 서비스
@Controller
public class AcornController {

    @GetMapping("/acornForm")

    //빈 객체를 생성해서 모델에 저장해줌
    public String acornForm(@ModelAttribute Acorn acorn){
        return "acornForm";
    }


    @PostMapping("/acorn")
    public String acorn(@ModelAttribute Acorn acorn){
        //return "redirect:/home";  //성공

        return "acornForm";     //실패
    }


}
