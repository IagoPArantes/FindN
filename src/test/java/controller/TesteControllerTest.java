package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;



class TesteControllerTest {

    @GetMapping("/teste")
    @ResponseBody
    public String teste() {
        return "Controller funcionando!";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}