package com.example.day02Batis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@org.springframework.stereotype.Controller
public class MemberController {

    @Autowired
    MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    //조회
    @GetMapping("/members")
    public String getMembers(Model model){
        List<Member> list = memberService.getMembers();
        model.addAttribute("list",list);
        return "memberlist";
    }

    //등록화면
    @GetMapping("/form")
    public String form(){
        return "formView";
    }


    //등록하기
    @PostMapping("/formProc")
    public String forProc(@ModelAttribute Member member){   //생성자, 세터
        System.out.println(member);

        //
        memberService.registerMember(member);
        return "ok";
    }

    //화면


    //등록하기



}
