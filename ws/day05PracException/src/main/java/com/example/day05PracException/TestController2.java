package com.example.day05PracException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.SQLException;

//예외처리를 직접하기
//예외 발생하면 에러뷰를 보여주고, 아니면 정상적인 뷰가 보이도록

@Controller
public class TestController2 {


    @GetMapping("/method1")
    public String method1(){
        String viewName = "method1View";
        try {
            throw new SQLException("db 오류났다");
        } catch (SQLException e) {
            //예외발생하면 errSQL로 가
            viewName ="errSQL";
        }

        return viewName;


    }


    @GetMapping("/method2")
    public String method2(){
        String viewName = "method1View2";
        try {
            throw new SQLException("db 오류났다");
            //service.getMembers();
        } catch (SQLException e) {
            //예외발생하면 errSQL로 가
            viewName ="errSQL";
        }
        return viewName;
    }


    @GetMapping("/method3")
    public String method3(){
        String viewName = "method1View3";
        try {
            throw new SQLException("db 오류났다");
        } catch (SQLException e) {
            //예외발생하면 errSQL로 가
            viewName ="errSQL";
        }
        return viewName;
    }


    /*
    @GetMapping("/method2")
    public String method2(){
        String viewName = "";
        int result = 2;

        if(result==1){
            //오류발생

            try {
                throw new SQLException("db 오류발생!!");
            } catch (SQLException e) {
                //throw new RuntimeException(e);
                viewName = "errSQL";
            }
        }else if(result==2){
            viewName = "method2View";
        }
        return viewName;

    }

    */

}
