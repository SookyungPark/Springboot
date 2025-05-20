package com.example.day05PracRestAPI;

//데이터 응답하기

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MemberAPIController {

    // 서버에게 데이터 응답할 때 룰?
    //요청이름을 '명사'로 해라
    //요청구분은 매서드 타입으로 구분해
    //@ResponseBody
    @GetMapping("/members")
    public List<Member> memberList(){

        List<Member> list = new ArrayList<>();
        list.add(new Member("acorn1", "브래드피트", "bread@google.com"));
        list.add(new Member("acorn2", "키아누리브스", "키아누@google.com"));
        list.add(new Member("acorn3", "리차드막스", "리차드@google.com"));
        return list;
    }

    //회원등록하기

    //모든 매핑에 @RestController 이게 됐다고?
    //@ResponseBody
    @PostMapping("/members")
    public String memberRegister(@RequestBody Member member){
        System.out.println(member.getId());
        System.out.println(member.getName());
        System.out.println(member.getEmail());

        //서비스, repository => 데이터베이스 등록하기


        return "성공";
    }

    //해당하는 고객의 정보 조회하기
    //스크립트에서 /members/${id}

    //@ResponseBody
    @GetMapping("/members/{id}")
    public Member getMember(@PathVariable(name="id") String id){
        System.out.println(id);
        //id에 대한 고객정보 조회하기, service, repository


        Member m = new Member("acorn1", "브래드피트", "bread@google.com");
        return m;

    }

    //@ResponseBody
    @DeleteMapping("/members/{id}")
    public String memberDelete(@PathVariable(name="id") String id){
        System.out.println(id);
        //서비스 -> repository -> 데이터베이스삭제
        return "성공";
    }
}
