package com.bluebird.bluebird.controller.member;

import com.bluebird.bluebird.domain.Member;
import com.bluebird.bluebird.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor //생성자 주입
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/regist")
    public String registerForm(){
        return "memberRegist";
    }

    @PostMapping("/regist")
    public String register(Member member, RedirectAttributes redirectAttributes){
        return "redirect:/";
    }
}
