package prac16.controllers;

import prac16.model.Departure;
import prac16.model.PostOffice;
import prac16.service.DepartureService;
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
    public String add(@RequestParam int Postoffice_id, @RequestParam String type, @RequestParam String departureDate){
        Departure departure = new Departure();
        departure.setType(type);
        departure.setPostoffice_id(Postoffice_id);
        departure.setDepartureDate(departureDate);
        departureService.addDeparture(departure);
        return "Добавлен: " + type + " " + departureDate;
    }
    @GetMapping("/get")
    @ResponseBody
    public List<Departure> get(){
        return departureService.getDepartures();
    }
    @GetMapping("/del/{id}")
    public String remove(@PathVariable int id){
        return departureService.deleteDeparture(id);
    }

    @GetMapping(value = "/{postofficeid}/postoffice")
    @ResponseBody
    public PostOffice getPostUser(@PathVariable("postofficeid") int postofficeid){
        return departureService.getPostOfficeByDeparture(postofficeid);
    }
}