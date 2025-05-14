package com.acorn.day01Hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalcController {

    @Autowired
    CalcService service;
    @GetMapping("/calc1234")
    public String calc(
            @RequestParam("su1") int su1,
            @RequestParam("su2") int su2,
            @RequestParam("o") String o,
            Model model){


        System.out.println(su1);
        System.out.println(su2);
        System.out.println(o);   //%2B
               // +  = >  공백  (%2B)
               //  +  =>  urlencoding 해서 사용

         //int result = su1+su2;
    int result=0;

    if(o.equals("+")){   ////%2B
            result = service.add(su1, su2);
            System.out.println(result);
        }
    else if(o.equals("plus")){
        result = service.add(su1, su2);
        System.out.println(result);
    }else if(o.equals("-")){
        result = service.minus(su1, su2);
        System.out.println(result);
    }else if(o.equals("*")){
        result = service.multiple(su1, su2);
        System.out.println(result);
    }else{
        result = service.divide(su1, su2);
        System.out.println(result);
    }
        model.addAttribute("result",result);


        return "calcView";
    }

}
