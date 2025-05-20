package com.example.prj;

import com.example.prj.login.BoardUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BangController {

    @Autowired
    BangService bangService;

    @Autowired
    public BangController(BangService bangService) {
        this.bangService = bangService;
    }


    //조회
    @GetMapping("/bang")
    public String getMembers(Model model){
        List<Bang> list = bangService.getBang();
        model.addAttribute("list",list);
        return "banglist";
    }

    //등록화면
    @GetMapping("/form")
    public String form(){
        return "formView";
    }


    @PostMapping("/formProc")
    public String insertBang(Bang bang, Model model) {
        int result = bangService.registerBang(bang);
        model.addAttribute("bang", bang);
        return "redirect:/bang";
    }



    @GetMapping("/formView")
    public String showForm() {
        return "formView"; // 템플릿 이름 (formView.html)
    }



}
