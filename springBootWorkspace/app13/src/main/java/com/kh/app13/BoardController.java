package com.kh.app13;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectResult;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URL;

@Controller
@RequestMapping("board")
@RequiredArgsConstructor
public class BoardController {

    private final AmazonS3 s3;

    @Value("${aws.s3.bucket-name}")
    private String bucketName;

    @GetMapping("write")
    public String write(){
        return "board/write";
    }

    @PostMapping("write")
    @ResponseBody
    public String write(MultipartFile f) throws Exception {

        //S3 에 업로드
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType( f.getContentType() );
        metadata.setContentLength( f.getSize() );
        PutObjectResult putObjectResult = s3.putObject(bucketName, f.getOriginalFilename(), f.getInputStream(), metadata);

        //파일 URL 가져오기
        URL url = s3.getUrl(bucketName, f.getOriginalFilename());
        System.out.println("url = " + url);

        return "uplaod ok ~~~";
    }

}
