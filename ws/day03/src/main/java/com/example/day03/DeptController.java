package com.example.day03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class DeptController {

    @Autowired
    DeptService service;

    @GetMapping("/dept")
    public String getDept(@ModelAttribute Dept dept, Model model){
        System.out.println(dept);
        List<Dept> list = service.getDept(dept);
        model.addAttribute("list", list);

        return "dept";

    }


}
