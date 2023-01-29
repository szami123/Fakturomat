package com.example.Fakturowanie.user;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class UserController {




    @GetMapping("/")
    public String index() {
        return "index";
    }
}
