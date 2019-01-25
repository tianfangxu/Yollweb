package com.yollweb.springboot.cloud.service.impl.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件上传controller
 * 上传大文件是路径必须带 "/zuul"
 */
@Controller
public class FileUploadController {
    private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    @RequestMapping(value="/upload",method= RequestMethod.POST)
    @ResponseBody
    public String StringhandleFileUpload(@RequestParam(value="file",required=true) MultipartFile file){
        try {
            byte[] in = file.getBytes();
            File out = new File(file.getOriginalFilename());
            FileCopyUtils.copy(in, out);
            return out.getAbsolutePath();
        } catch (IOException e) {
            // TODO Auto-generatedcatch block
            e.printStackTrace();
        }
        return null;
    }
}
