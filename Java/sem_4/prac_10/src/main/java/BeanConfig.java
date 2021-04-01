import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public Firefly firefly(){
        return new Firefly();
    }
    @Bean
    public Flashlight flashlight(){
        return new Flashlight();
    }
    @Bean
    public Lamp lamp(){
        return new Lamp();
    }

}
