package com.example.prj;

import org.springframework.beans.factory.annotation.Autowired;
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


    //등록하기
    @PostMapping("/formProc")
    public String forProc(@ModelAttribute Bang bang){   //생성자, 세터
        System.out.println(bang);

        //
        bangService.registerBang(bang);
        return "ok";
    }


    //

    /*
    //@ResponseBody
    @GetMapping("/bang")
    public List<Bang> getBang(){

        return repository.selectAll();


    }


    //writer,title,content,board_pw, creat_at(자동생성되도록?)

    @ResponseBody
    @GetMapping("/register")
    public int register(){
        Bang b = new Bang();
        b.setWriter("tester");
        b.setTitle("제목을 써");
        b.setContent("내용을 넣어");
        b.setBoard_pw("비밀번호를 넣어");

        return repository.insert(b);

    }

    //글 등록

    @PostMapping("/register")
    public int register(@RequestBody Bang b) {
        // JSON으로 들어온 데이터를 자동으로 Bang 객체에 바인딩함
        return repository.insert(b);
    }
    */

}
