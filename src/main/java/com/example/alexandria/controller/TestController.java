package com.example.alexandria.controller;

import com.example.alexandria.services.DocumentEncryption;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class TestController {

    @Value("${spring.application.name}")
    String appName;


    @GetMapping("/")
    public String getAppName() throws IOException, DocumentException {
        DocumentEncryption docEnc = new DocumentEncryption("C:/Users/aleja/Downloads/NewSQLbinani-2016-cae-652418.pdf");
        docEnc.encryptDoc("test1234", "test12345");
        return this.appName;
    }
}
