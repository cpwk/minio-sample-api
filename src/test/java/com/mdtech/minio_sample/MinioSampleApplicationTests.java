package com.mdtech.minio_sample;

import com.alibaba.fastjson.JSON;
import com.mdtech.minio_sample.api.file.entity.UploadToken;
import com.mdtech.minio_sample.api.file.service.IFileService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MinioSampleApplicationTests {

    @Autowired
    private IFileService fileService;

    @Test
    public void contextLoads() throws Exception {

        UploadToken token = fileService.presignedPutObject("test", "aaa.jpg", 12344);

        System.out.println(JSON.toJSONString(token));
    }

}
