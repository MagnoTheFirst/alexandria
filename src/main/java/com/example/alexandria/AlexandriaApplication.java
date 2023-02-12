package com.example.alexandria;

import com.example.alexandria.services.DocumentEncryption;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class AlexandriaApplication {

    public static void main(String[] args) throws IOException {

        SpringApplication.run(AlexandriaApplication.class, args);
    }

}
