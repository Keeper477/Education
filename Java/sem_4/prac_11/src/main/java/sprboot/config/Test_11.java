package sprboot.config;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test_11 {
    @RequestMapping("/Hello")
    public String test(){
        return "Hi";
    }
}
