package sprboot.config;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
class HomeController {

    @GetMapping("/home")
    public String getIndex() {
        return "Home.html";
    }
}

@RequestMapping("/home/departure")
@RestController
class DepartureController {
    List<Departure> list = new ArrayList<>();
    @GetMapping("/add")
    public String add(@RequestParam String type, @RequestParam String departureDate){
        for (Departure departure : list) {
            if(departure.departureDate.equals(departureDate)) {
                return "На эту дату занято";
            }
        }
        list.add(new Departure(type, departureDate));
        return "Добавлен: " + type + " " + departureDate;
    }
    @GetMapping("/get")
    public String get(){
        StringBuilder str = new StringBuilder();
        for (Departure departure : list) {
            str.append(departure.getType()).append(" ").append(departure.getDepartureDate());
        }
        if (str.length() != 0)
            return "Держи: " + str;
        return "Пусто";
    }
    @GetMapping("/del/{departureDate}")
    public String remove(@PathVariable String departureDate){
        for(int i=0; i<list.size(); i++){
            if(list.get(i).departureDate.equals(departureDate)){
                String str = list.get(i).getType() + " " + list.get(i).getDepartureDate();
                list.remove(i);
                return "Удалил: " + str;
            }
        }
        return "Такого нет";
    }
}
@RestController
class PostOfficeController {
    List<PostOffice> list = new ArrayList<>();
    @GetMapping("/add")
    public String add(@RequestParam String name, @RequestParam String cityName){
        for (PostOffice postOffice : list) {
            if(postOffice.name.equals(name)) {
                return "Такой уже есть";
            }
        }
        list.add(new PostOffice(name, cityName));
        return "Добавлен: " + name + " " + cityName;
    }
    @GetMapping("/get")
    public String get(){
        StringBuilder str = new StringBuilder();
        for (PostOffice postOffice : list) {
            str.append(postOffice.getName()).append(" ").append(postOffice.getCityName());
        }
        if (str.length() != 0)
            return "Держи: " + str;
        return "Пусто";
    }
    @GetMapping("/del/{name}")
    public String remove(@PathVariable String name){
        for(int i=0; i<list.size(); i++){
            if(list.get(i).name.equals(name)){
                String str = list.get(i).getName() + " " + list.get(i).getCityName();
                list.remove(i);
                return "Удалил: " + str;

            }
        }
        return "Такого нет";
    }
}

