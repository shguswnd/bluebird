package com.bluebird.bluebird.controller.member;

import com.bluebird.bluebird.service.common.FilesService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequestMapping("/userMain")
@RequiredArgsConstructor
public class MemberMainController {

    private final FilesService filesService;

    @GetMapping
    public String userMain(){
        return "/member/userMain";
    }
/**
 * public String fileDrive(@RequestParam("memberId") String memberId, RedirectAttributes redirectAttributes)
 * RedirectAttributes를 사용할때 addAttribute() 메서드를 사용하면 쿼리 파라미터를 URL에 노출한다.
 * 반면에 addFlashAttribute() 메서드를 사용하면 쿼리 파라미터를 세선에 저장하고,
 * 리다이렉트 후에 한번 사용되면 세션에서 제거한다.
 * 민감정보일때 사용하자.
 * */
    @GetMapping("/fileDrive")
    public String fileDrive(HttpSession session){
        String memberId = (String) session.getAttribute("userId");
        log.info("memberId : " + memberId);
        //추후에 사용 현재 여긴 필요가 없음
//        return "/common/fileDrive/{memberId}";
//        return "redirect:/common/fileDrive?memberId=" + memberId;
//        return "/common/fileDrive?memberId=" + memberId;
//        return "redirect:/common/fileDrive";
        return "/common/fileDrive";
    }

    @PostMapping("/fileUpload")
    public String fileUpload(MultipartFile[] files, HttpSession session){

        String memberId = (String) session.getAttribute("userId");

        filesService.uploadFile(files, memberId);
        return "redirect:/";
    }

}
