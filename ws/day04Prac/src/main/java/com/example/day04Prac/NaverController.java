package com.example.day04Prac;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class NaverController {

    @Autowired
    //NaverApi2 api;
    NaverApi4 api;


    @ResponseBody
    @GetMapping(value = "/naverData", produces = "application/json;charset=utf-8")
    public String getData(){
        String data = api.getData();
        return data;
    }

    @ResponseBody
    @GetMapping("/naverList")
    public List<ItemDTO> getDataList(){
        String data = api.getData();
        List<ItemDTO> list = api.extracted(data);
        return list;

    }

    @GetMapping("/naverView")
    public String getNaverView(Model model){
        String data = api.getData();
        List<ItemDTO> list = api.extracted(data);
        model.addAttribute("list",list);

        return "naverView";

    }

}
