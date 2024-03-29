package com.bluebird.bluebird.controller.admin;


import com.bluebird.bluebird.service.common.FilesService;
import com.bluebird.bluebird.utils.FileUtils;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


@Slf4j
@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class adminController {

    private final FilesService filesService;


    @GetMapping
    public String admins() {return "/admin/index";}

    @PostMapping("/fileUpload")
    public String fileUpload(MultipartFile[] files, HttpSession session){
        String memberId = (String) session.getAttribute("userId");
        filesService.uploadFile(files,memberId);
        return "redirect:/index";
    }
}
