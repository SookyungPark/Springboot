package com.example.day02Batis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class DeptController {

    @Autowired
    DeptService service;

    @ResponseBody
    @GetMapping("/dept")
    public List<Map<String, Object>> getDept(){
        List<Map<String, Object>>list = service.getDeptList();
        return list;
    }
}
