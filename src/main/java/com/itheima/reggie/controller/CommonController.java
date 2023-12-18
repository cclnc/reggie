package com.itheima.reggie.controller;

import com.itheima.reggie.common.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

//文件上传下载
@RestController
@RequestMapping("/common")
public class CommonController {

    @PostMapping("/upload")
    public R<String> upload(MultipartFile file){
        return null;
    }

}
