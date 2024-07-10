package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/") // 도메인 접속했을 때 아래 메서드가 호출하게 된다
    public String home(){
        return "home";
    }
}
