package com.josenavarro.holaspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * MainController
 */

@Controller
public class MainController{
    @GetMapping("/") // Entradas en la tabla de rutas solo una por dirección, ejecuta el método de abajo al encontrar /
    @ResponseBody // Busca plantilla timelift que responde el nombre que le pongamos
    public String holaMundo(){
        return "Hola buenos dias";
    }
    
    @GetMapping("/ingles") // Entradas en la tabla de rutas solo una por dirección
    @ResponseBody // Busca plantilla timelift que responde el nombre que le pongamos
    public String holaMundoE(){
        return "Hello World";
    }

}