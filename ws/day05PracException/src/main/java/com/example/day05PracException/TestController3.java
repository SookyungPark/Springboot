package com.example.day05PracException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.SQLException;

@Controller
public class TestController3 {

    //클래서내에서 발생하는 예외처리방법을 해볼게


    //나한테 와 내가 한꺼번에 오류 처리해줄게
    //Exception.class ㅇ건 다 처리해주는거고
    //SQLException.class 이건 sql 오류 다 처리해줌
    /*
    @ExceptionHandler(SQLException.class)
    public String catcher( SQLException ex, Model model){


        //에러객체정보를 뷰에서 활용할 수 있다
        //model.addAttribute("ex",ex);


        return "errSQL";
    }
    */

    @GetMapping("/method4")
    public void method4() throws SQLException {
        throw new SQLException("db 오류");
    }

    @GetMapping("/method5")
    public void method5() throws SQLException {
        throw new SQLException("db 오류");
    }

    @GetMapping("/method6")
    public void method6() throws SQLException {
        throw new SQLException("db 오류");
    }

}
