package com.example.prac.controllers;

import com.example.prac.model.PostOffice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.prac.service.PostOfficeService;

import java.util.List;

@RequestMapping("/home/postoffice")
@RestController
public class PostOfficeController {
    @Autowired
    private PostOfficeService postOfficeService;
    @GetMapping("/add")
    @ResponseBody
    public String add(@RequestParam String name, @RequestParam String cityName){
        PostOffice postOffice = new PostOffice();
        postOffice.setName(name);
        postOffice.setCityName(cityName);
        postOfficeService.addPostOffice(postOffice);
        return "Добавлен: " + name + " " + cityName;
    }
    @GetMapping("/get")
    @ResponseBody
    public List<PostOffice> get(){
        return postOfficeService.getPostOffices();
    }
    @GetMapping("/del/{name}")
    public String remove(@PathVariable String name){
        return postOfficeService.deletePostOffice(name);
    }
}