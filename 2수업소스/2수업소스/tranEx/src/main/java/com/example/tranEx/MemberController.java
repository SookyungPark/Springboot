package com.example.tranEx;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    @Autowired
    MemberService service;

    /*
    회원가입시 포인트 적립을 해준다
    회원가입이라는 것 안에 회원테이블, 포인트 테이블에 회원의 포인트 등록,
    => 하나의 논리적 단위로 묶어서 수핻되거나, 수행되지 않게 하기 (=트렌젝션)
    트렌젝션으로 묶어놓으면 같이 처리되니깐 예외가 발생했을 때 다 같은 운명이 된다..?

    */



    @GetMapping("/join")
    public String  join(){

        Member  member= new Member();
        member.setId("acorn");
        member.setName("홍길동");


        service.회원가입포인트적립(member);
        return "ok";
    }

}
