package com.bluebird.bluebird.controller.member;


import com.bluebird.bluebird.domain.Member;
import com.bluebird.bluebird.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Slf4j
@Controller
@RequestMapping("/member")
@RequiredArgsConstructor //생성자 주입
public class MemberController {

    private final MemberService memberService;


    @GetMapping
    public String members(){
        return "/member/login";
    }

    @GetMapping("/signup")
    public String signUp(){
        return "/member/memberSignup";
    }

    @PostMapping("/signup")
    public String signUp(@ModelAttribute("member") Member member, RedirectAttributes redirectAttributes){

        log.trace("trace log={}", member.toString());
        log.debug("debug log={}", member.toString());
        log.info("info log={}", member.toString());
//        log.warn("warn log={}", member.toString());
//        log.error(" error log={}", member.toString());
//        memberService.createMember(member);
        return "redirect:/member";
    }
}
