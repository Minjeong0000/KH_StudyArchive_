package com.kh.app12.member;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member")
public class MemberController {

    @GetMapping("login")
    public String login(@CookieValue(required = false) String savedId, Model model){
        model.addAttribute("savedId" , savedId);
        return "member/login";
    }

    @PostMapping("login")
    public String login(HttpServletResponse resp, String id, String pwd){
        boolean loginSuccess = id.equals("admin") && pwd.equals("1234");
        if(loginSuccess){
            Cookie c = new Cookie( "savedId" , id );
            c.setMaxAge(30);
            c.setPath("/member");
            resp.addCookie( c );
        }
        return "redirect:/home";
    }


}
