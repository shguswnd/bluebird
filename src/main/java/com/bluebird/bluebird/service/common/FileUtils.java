package com.bluebird.bluebird.service.common;

import com.bluebird.bluebird.repository.common.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
@Component
public class FileUtils {

    private final FileRepository fileRepository;


    public void uploadFile(MultipartFile file){
//        String dynamicPath = "/" + generateDynamicPath(); //동적 경로
        String dynamicPath = generateDynamicPath(); //동적 경로

        //파일 저장
        try {
            file.transferTo(Paths.get(dynamicPath).resolve(file.getOriginalFilename()));
        }catch (IOException e){
            e.printStackTrace();
        }

    }



    private String generateDynamicPath() {
        //동적인 경로 생성 추후에 아이디로 변경.
        String dynamicPath = DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now());
        try {
            Files.createDirectories(Paths.get(dynamicPath));
        } catch (IOException e){
            e.printStackTrace();
        }
        return dynamicPath;
    }

}
