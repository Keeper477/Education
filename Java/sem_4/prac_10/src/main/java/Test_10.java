import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test_10 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        Lighter lighter = context.getBean(Flashlight.class);
        lighter.doLight();

        lighter = context.getBean(Firefly.class);
        lighter.doLight();

        lighter = context.getBean(Lamp.class);
        lighter.doLight();
    }

}
