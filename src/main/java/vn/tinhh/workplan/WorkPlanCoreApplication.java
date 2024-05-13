package vn.tinhh.workplan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class WorkPlanCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkPlanCoreApplication.class, args);
    }

    @GetMapping("/simple-request")
    public String simpleRequest() {
        return "oke";
    }
}
