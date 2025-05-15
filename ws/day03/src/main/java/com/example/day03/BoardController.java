package com.example.day03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

/*
게시판 조회하기
-전체 조회하기
-작성자로 조회하기
-내용으로 조회하기
-제목으로 조회하기

(게시판 화면에서
1) 입력정보 확인
 검색조건 : condition, 검색어 : keyword
 를 서버측으로 보낼거고 -> 서버가 이 정보를 받으면돼)

2) 입력정보 기반의 db repository 만들기
-우리는 마이바티스 쓰니까 매퍼 만들고
-repository 만들기
-repository 테스트하기
*/



@Controller
public class BoardController {

    @Autowired
    BoardService service;



    @GetMapping("/board")
    public String board(@ModelAttribute  SearchCondition search, Model model){
        System.out.println(search);
        List<BoardDTO> list = service.getSearchBoard(search);
        model.addAttribute("list", list);
        return "boardList";
    }




}
