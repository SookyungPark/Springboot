package com.example.day07SessionPrac;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {


    @GetMapping("/home")
    public String home(){
        return "home";
    }


    @GetMapping("/loginForm")
    public String loginForm(){
        return "loginForm";

    }


    @PostMapping("/login")
    public String login(@ModelAttribute User user,
                        HttpServletRequest request){
        System.out.println(user.getId());

        if(!check(user)){   //사용자 확인이 안된경우
            return "loginForm";
        }

        //인증완료된 후에 세션저장소에 로그인정보 저장하기

        HttpSession session = request.getSession();
        //request.getSession(true) true 생략 가능

        //사용자 세션 얻어오기
        //기존 사용자 세션이 있으면 있는 세션 반환
        //세션없으면 새로운 세션 반환
        //다른 요청에서도 사용할 정보를 저장함 (세션에 저장하기)
        session.setAttribute("USERID", user.getId());



        return "redirect:/home";
    }

    //사용자 check
    boolean check(User user){    //id, pw 같으면 로그인 성공
        if(user.getId().equals(user.getPw())){
            return true;
        }else{
            return false;
        }
    }

    @GetMapping("/logOut")
    String logOut(HttpServletRequest request){
        //세션 정보 삭제하기
        HttpSession session = request.getSession(false);
        session.invalidate();   //다 지우기



        //session.removeAttribute();  //괄호 안에만 지우기


        return "redirect:/home";
    }



}
