package prac23.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import prac23.model.PostOffice;
import prac23.service.PostOfficeService;

import java.util.List;

@RequestMapping("/home/postoffice")
@Controller
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

    @GetMapping("/del/{id}")
    public String remove(@PathVariable int id){
        return postOfficeService.deletePostOffice(id);
    }

    @GetMapping("/get/sorted/cityname")
    @ResponseBody
    public List<PostOffice> getSortedPostOfficesByCityName(){
        return postOfficeService.getSortedPostOfficesByCityName();
    }

    @GetMapping("/get/sorted/name")
    @ResponseBody
    public List<PostOffice> getSortedPostOfficesByName(){
        return postOfficeService.getSortedPostOfficesByName();
    }

}
