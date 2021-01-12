package sk.stuba.fei.homeoffice.bp.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
        log.info("Open in browser: http://localhost:8080");
    }

    public void run(String... args) throws Exception {
        //System.out.println("Hello world");
    }

}
