package com.example.day03;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    /*
    home -> main 화면 보여주기
    main 화면에서 정보를 조회할 고객선택하기
    선택한 고객의 정보 조회하기

    내가 해야할 것
    1) 사용자가 선택한 정보 여러개 얻어와야함
    2) 얻어온 정보들을 조회하기
        -mapper 작성 시,
        -select * from membertbl where id in
        ( in 뒤에 오는걸 동적으로 만들거임)
        =동적으로 만드려면? foreach 사용하면 됨!
        -select * from membertbl where id in ('acorn')
        -select * from membertbl where id in ('acorn','acorn3')
        -select * from membertbl where id in ('acorn','acorn3','acorn4')

    3)

    */
    @GetMapping("/home")
    public String home(){
        return "main";
    }

}
