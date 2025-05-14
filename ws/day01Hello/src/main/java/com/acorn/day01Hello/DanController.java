package com.acorn.day01Hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class DanController {


    @ResponseBody
    @GetMapping("/dan3")
    public String dan3(Model model){

        String result ="";

        for(int i=1; i<=9; i++){
            System.out.println("3*"+i+"="+(3*i));
        }
        model.addAttribute("result",result);

        return "result";
    }


    //3. 원하는단 제공하기 (원하는단을 제공하는 서비스)/dan?num=3
    @ResponseBody
    @GetMapping("/dan")
    public String dandan(
            @RequestParam("num")int num){

        String result = "";

        for (int i = 1; i <= 9; i++) {
            result += num + " * " + i + " = " + (num * i) + "<br>";
        }

        return result;
    }

    //5. 원하는 수만큼의 별을 출력하기 ( 원하는 수만큼 별을 출력하는 서비스제공하기) /star?cnt=5

    @ResponseBody
    @GetMapping("/star")
    public String star(
            @RequestParam("star")int star
    ){


        return null;
    }

    //8. 랜덤한 화이팅메시지 제공하기 /message/random


    @ResponseBody
    @GetMapping("/message")
    public String message(){
        int result = (int)(Math.random()*5)+1;
        switch: result{

        } case 1:

        return null;
    }



}
