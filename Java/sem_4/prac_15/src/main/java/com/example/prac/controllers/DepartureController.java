package com.example.prac.controllers;

import com.example.prac.model.Departure;
import com.example.prac.service.DepartureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/home/departure")
@Controller
public class DepartureController {

    @Autowired
    private DepartureService departureService;

    @GetMapping("/add")
    @ResponseBody
    public String add(@RequestParam String type, @RequestParam String departureDate){
        Departure departure = new Departure();
        departure.setType(type);
        departure.setDepartureDate(departureDate);
        departureService.addDeparture(departure);
        return "Добавлен: " + type + " " + departureDate;
    }
    @GetMapping("/get")
    @ResponseBody
    public List<Departure> get(){
        return departureService.getDepartures();
    }
    @GetMapping("/del/{departureDate}")
    public String remove(@PathVariable String departureDate){
        return departureService.deleteDeparture(departureDate);
    }
}