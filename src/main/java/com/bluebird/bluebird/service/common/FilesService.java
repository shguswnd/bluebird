package com.bluebird.bluebird.service.common;

import com.bluebird.bluebird.utils.FileUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class FilesService {

    private final FileUtils fileUtils;

    public void uploadFile(MultipartFile file){
        fileUtils.fileRefine(file);
    }
}
