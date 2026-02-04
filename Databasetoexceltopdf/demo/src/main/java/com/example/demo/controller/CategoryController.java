package com.example.demo.controller;

import com.example.demo.service.ExcelService;
import jakarta.annotation.Resource;
import org.apache.poi.ss.usermodel.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.InputStream;



@RestController
@RequestMapping("/cateqories")
public class CategoryController {
    @Autowired
    private ExcelService service;

    @RequestMapping("/excel")
    public ResponseEntity<Resource> download(){

        String filename = "categories.xlsx";

        ByteArrayInputStream actualData =service.getActualData();
        InputStreamResource file=new InputStreamResource(actualData);

       ResponseEntity<Resource> body= ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,...headerValues:"attach")
}