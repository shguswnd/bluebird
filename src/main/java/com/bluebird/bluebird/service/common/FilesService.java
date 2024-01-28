package com.bluebird.bluebird.service.common;

import com.bluebird.bluebird.domain.FilesLg;
import com.bluebird.bluebird.repository.common.FileRepository;
import com.bluebird.bluebird.utils.FileUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class FilesService {

    private final FileUtils fileUtils;
    private final FileRepository fileRepository;


    public void uploadFile(MultipartFile[] files){
        log.info(String.valueOf(files.length));
        System.out.println(files.length);
        try {
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    FilesLg refinedFile = fileUtils.fileRefine(file);
                    fileRepository.save(refinedFile);
                }else{
                    log.warn("file are empty");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
