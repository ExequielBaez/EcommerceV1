package com.ecommerce.EcommerceV1.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UploadFileService {

    String upload (MultipartFile multipartFile) throws IOException;

    void delete(String nameFile);
}
