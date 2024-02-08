package com.bluebird.bluebird.controller.common;

import com.bluebird.bluebird.service.common.FilesService;
import com.bluebird.bluebird.utils.FileUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/fileDrive")
@RequiredArgsConstructor
public class FileController {

    //    private final FileUtils fileUtils;
    private final FilesService filesService;

    @GetMapping("/{memberId}")
    public String memberFileDrive(@PathVariable(name = "memberId") Long memberId){
        log.info("memberId : " + memberId);
        return "/common/fileDrive/{memberId}";
    }
}
