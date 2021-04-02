package sprboot.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.*;

@Component
public class Test_12 {
    File file;
    @Value("${file1}")
    String file1;
    @Value("${file2}")
    String file2;
    @PostConstruct
    public void read() throws IOException {
        file = new File(".\\Java\\sem_4\\prac_12\\src\\main\\resources", file1);
        StringBuilder str = new StringBuilder();
        if (!file.exists()) {
            str = new StringBuilder("null");
        }
        else {
            FileReader fr = new FileReader(file);
            int i;
            while ((i = fr.read()) != -1) {
                str.append((char) i);
            }
            fr.close();
            str = new StringBuilder(Integer.toString(str.toString().hashCode()));
        }
        File out = new File(".\\Java\\sem_4\\prac_12\\src\\main\\resources", file2);
        if (out.exists()){
            FileWriter fw = new FileWriter(out, false);
            fw.write(str.toString());
            fw.close();
        }
    }
    @PreDestroy
    public void delete(){
        file = new File(".\\Java\\sem_4\\prac_12\\src\\main\\resources", file1);
        if(file.delete()){
            System.out.println("Папка была удалена");
        } else System.out.println("Папка не была найдена");

    }
}
