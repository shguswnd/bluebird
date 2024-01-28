package com.bluebird.bluebird.utils;

import com.bluebird.bluebird.domain.FilesLg;
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
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Component
public class FileUtils {

    private final FileRepository fileRepository;


    public FilesLg fileRefine(MultipartFile file){
//        String dynamicPath = "/" + generateDynamicPath(); //동적 경로
        Path filePath = generateDynamicPath(); //동적 경로
        FilesLg filesLg = FilesLg.builder().build();
        //파일 저장
        try {
            UUID uuid = UUID.randomUUID();
            System.out.println("name : " + file.getName());
            System.out.println("getOriginalFilename : " + file.getOriginalFilename());
            System.out.println("getResource : " + file.getResource());
            System.out.println("getContentType : " + file.getContentType());
            System.out.println("getInputStream : " + file.getInputStream());
            System.out.println("getSize : " + file.getSize());
            System.out.println("getBytes : " + file.getBytes());


            filesLg = FilesLg.builder()
                    .fileNum(uuid.toString() + "_" + file.getOriginalFilename())
                    .fileName(file.getOriginalFilename())
                    .fileSize(file.getSize())
                    .upName(null)
                    .build();

            // 파일을 서버에 옮기기
            file.transferTo(filePath.resolve(file.getOriginalFilename()));
        }catch (IOException e){
            e.printStackTrace();
        }
        return filesLg;
    }



    private Path generateDynamicPath() {
        //절대경로 + 동적으로 하여 디텔토리 위치를 명시적으로 만들자.
        String basicPath = "/path";
        //동적인 경로 생성 추후에 아이디로 변경.
        String dynamicPath = DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now());
        Path absolutePath = Paths.get(basicPath).toAbsolutePath();
        Path filePath = absolutePath.resolve(dynamicPath);
        try {
//            Files.createDirectories(absolutePath.resolve(dynamicPath));
            Files.createDirectories(filePath);
        } catch (IOException e){

            e.printStackTrace();
        }
        return filePath;
    }

}
