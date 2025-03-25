package org.example.deekseek_backend.controller;

import cn.dev33.satoken.util.SaResult;
import lombok.extern.slf4j.Slf4j;
import org.example.deekseek_backend.utils.AliOSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

    @Autowired
    private AliOSS aliOSS;

    @PostMapping("/upload")
    public SaResult upload(String context) throws Exception {
        log.info("上传文件：{}", context);
        if (!context.isEmpty()) {
            // 生成唯一文件名
//            String originalFilename = context.getOriginalFilename();
//            String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
            String uniqueFileName = UUID.randomUUID().toString().replace("-", "") + ".txt";
            // 上传文件
            String url = aliOSS.upload(context.getBytes(), uniqueFileName);
            return SaResult.ok(url);
        }
        return SaResult.error("上传失败");
    }

}
