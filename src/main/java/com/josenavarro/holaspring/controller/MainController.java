package com.josenavarro.holaspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * MainController
 */

@Controller
public class MainController {
    @GetMapping("/")
    @ResponseBody
    public String holaMundo(){
        return "Hola buenos dias";
    }
}