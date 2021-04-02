package config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class Student {
    @Value("${student.name}")
    String name;
    @Value("${student.last_name}")
    String last_name;
    @Value("${student.group}")
    String group;
    @PostConstruct
    public void init(){
        System.out.println(name + " " + last_name + " " + group);
    }
}
