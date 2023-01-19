package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    /**
     * Welcome 페이지
     */
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "Hello!");
        return "hello";
    }

    /**
     * MVC와 템플릿 엔진
     */
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    /**
     * API
     * @ResponseBody 사용시 viewResolver 사용하지 X
     */
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name, Model model) {
        return "hello" + name;
    }

    /**
     * @ResponseBody를 사용하고 객체를 return하면 JSON으로 변환
     */
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);

        return hello;
    }

    /**
     * Inner Class
     */
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
