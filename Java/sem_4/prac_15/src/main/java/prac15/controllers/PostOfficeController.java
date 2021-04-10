package prac15.controllers;

import prac15.model.PostOffice;
import prac15.service.PostOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/del/{id}")
    public String remove(@PathVariable int id){
        return postOfficeService.deletePostOffice(id);
    }
}
