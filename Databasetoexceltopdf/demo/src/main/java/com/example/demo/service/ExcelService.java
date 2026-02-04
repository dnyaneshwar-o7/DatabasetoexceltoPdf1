package com.example.demo.service;

import com.example.demo.Repo.CategoryRepo;
import com.example.demo.helper.Helper;
import com.example.demo.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.util.List;

@Service
public class ExcelService {

    @Autowired
    private CategoryRepo repo;

    public ByteArrayInputStream getActualData(){
        List<Category> all =repo.findAll();
        ByteArrayInputStream byteArrayInputStream= Helper.dataToExcel(all);
        return byteArrayInputStream;
    }
}
