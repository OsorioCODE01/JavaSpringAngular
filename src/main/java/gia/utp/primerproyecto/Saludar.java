package gia.utp.primerproyecto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Saludar {
    @RequestMapping("/hello")
    public String hello(){
        return "Hello World";
    }
}
