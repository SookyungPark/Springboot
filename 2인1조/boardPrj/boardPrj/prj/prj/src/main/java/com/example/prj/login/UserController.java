package com.example.prj.login;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class UserController {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
        // 비밀번호를 암호화하는 부분
        user.setUserpw(passwordEncoder.encode(user.getUserpw()));
        userMapper.insertUser(user);
        return "redirect:/login";
    }


    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

        @GetMapping("/main")
        public String mainPage() {
            return "main";
        }

    @GetMapping("/")
    public String root() {
        return "redirect:/main";
    }

        @GetMapping("/user/main")
    public String home(Model model, @AuthenticationPrincipal BoardUserDetails userDetails) {
        if (userDetails != null) {
            String nickname = userDetails.getNickName();
            model.addAttribute("nickname", nickname);
        }
        return "main";  // 필요하다면 별도의 뷰 이름
    }

}
