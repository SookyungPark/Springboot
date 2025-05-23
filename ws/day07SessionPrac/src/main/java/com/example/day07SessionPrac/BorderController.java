package com.example.day07SessionPrac;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BorderController {

    @GetMapping("/board")
    public String getList(HttpServletRequest request){
        HttpSession session = request.getSession(false);

        //request.getSession(false);
        //세션 얻어올 때 false면 => 기존 세션이 없으먄 null반환
        //                     => 기존에 세션이 있다면 기본세션 반환

        if(session ==null || session.getAttribute("USERID")==null){
            //
            return "redirect:/loginForm";
        }


        return "boardList";
    }

}
