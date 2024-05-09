package com.ecommerce.EcommerceV1.service.impl;

import com.ecommerce.EcommerceV1.service.ProductService;
import com.ecommerce.EcommerceV1.service.UploadFileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
@Service
public class UploadFileServiceImpl implements UploadFileService {
    private final String FOLDER = "src//main//resources//static//images//";
    private final String IMG_DEFAULT = "no image.jpg";
    private final String URL = "http://localhost:8080/images/";

    public String upload (MultipartFile multipartFile) throws IOException {

        if(multipartFile != null){
            byte [] bytes = multipartFile.getBytes();
            Path path = Paths.get(FOLDER + multipartFile.getOriginalFilename());
            Files.write(path, bytes);
            return URL + multipartFile.getOriginalFilename();
        }

        return URL + IMG_DEFAULT;
    }

    public void delete(String nameFile){
        File file = new File(FOLDER + nameFile);
        file.delete();

    }
}
