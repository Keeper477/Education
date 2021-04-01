package prac_4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyExecutorService {
    MyExecutorService(int num){
        ExecutorService e = Executors.newFixedThreadPool(num);
        for(int i = 0; i < num; i++) {
            e.submit(() -> System.out.println("Hello"));
        }
        e.shutdown();
    }
}
