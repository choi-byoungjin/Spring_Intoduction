package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/") //@GetMapping이 우선순위이기때문에 index.html보다 우선순위가 됨
    public String home(){
        return "home";
    }
}
