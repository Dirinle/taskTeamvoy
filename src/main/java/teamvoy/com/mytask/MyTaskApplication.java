package teamvoy.com.mytask;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import teamvoy.com.mytask.modelSunriseSunset.Results;
import teamvoy.com.mytask.processor.GooglePlaceProcessor;
import teamvoy.com.mytask.processor.SunriseSunsetProcessor;

@SpringBootApplication
public class MyTaskApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MyTaskApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        UserInterface userInterface = new UserInterface();
        userInterface.run();
    }
}
