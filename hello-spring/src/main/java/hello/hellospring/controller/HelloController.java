package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// 웹 브라우저 -> localhost:8080/hello -> 내장 톰캣 서버 -> helloController -> viewResolver -> 웹브라우저
@Controller
public class HelloController {

    @GetMapping("hello") // 도메인/hello으로 접속했을 때
    public String hello(Model model) {
        model.addAttribute("data", "hello!!"); //키는 data이고 값은 hello!!이다.
        return "hello"; //hello.html 파일로 찾아가라
        // 컨트롤러에서 리턴 값으로 문자를 반환하면 viewResolver가 화면을 찾아서 처리한다.
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // mvc에서는 View가 있었지만, responsebody는 view 없이 데이터만 그대로 보여줌
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    // 웹 브라우저 -> localhost:8080/hello-api -> 내장 톰켓 서버 -> helloController -> httpMessageConverter -> 웹 브라우저
    @GetMapping("hello-api")
    @ResponseBody // 객체를 반환하고 @ResponseBody 하게 되면 JSON 형태로 HTTP 구성
    public Hello helloApi (@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}