package com.example.day05PracUpload;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.UUID;

@Controller
public class UploadController {

    @GetMapping("/uploadForm")
    public String uploadForm(){
        return "uploadForm";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam(name="goodsName")String goodsName,
                         @RequestParam(name="file")MultipartFile file,
                         Model model){

        //1. 등록한 정보 확인하기
        System.out.println(goodsName);
        System.out.println(file.getOriginalFilename());
        String fileOriginName = file.getOriginalFilename();

        //2. 겹치지 않는 이름으로 저장하기
        String uuid = UUID.randomUUID().toString();
        //원본파일의 확장자 추출해서 저장이름 만들기


        int index = fileOriginName.lastIndexOf(".");
        String ext = fileOriginName.substring(index+1);

        //
        String saveName = uuid+"."+ext;
        System.out.println(saveName);



        //3. 업로드하기
        String path="c:\\test\\upload\\";

        try {
            file.transferTo(new File(path+saveName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        model.addAttribute("fileName" , saveName);
        return "uploadok";
    }

    //이미지 보여주기

    //@ResponseBody
    //ResponseEntity

    /*
    @ResponseBody
    @GetMapping("/images/{fileName}")
    public Resource image(@PathVariable(name="fileName")String fileName) throws MalformedURLException {

        System.out.println(fileName);

        return new UrlResource("file:c:\\test\\upload\\"+fileName);
    }
    */


    @GetMapping("/images/{fileName:.*}")
    public ResponseEntity<Resource> images(@PathVariable(name="fileName")String fileName) throws MalformedURLException {
        System.out.println(fileName);
        Resource reSource = new UrlResource("file:c:\\test\\upload\\"+fileName);

        return ResponseEntity.ok().body(reSource);
    }

}
