package com.josenavarro.holaspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * MainController
 */

@Controller
public class MainController{
    @GetMapping("/") // Entradas en la tabla de rutas solo una por dirección, ejecuta el método de abajo al encontrar "/" es la ruta servidor
    @ResponseBody // Busca plantilla timelift que responde el nombre que le pongamos
    public String holaMundo(@RequestParam("nombre") String name, @RequestParam("edad") Integer edad){ /** Request es la petición y Response la respuesta, lo captura y lo guarad en el String name */
        return "Hola "+name+", edad "+edad; // http://localhost:8080/?nombre=Jose&edad=36
    }
    
    @GetMapping("/ingles") // Entradas en la tabla de rutas solo una por dirección
    @ResponseBody // Busca plantilla timelift que responde el nombre que le pongamos
    public String holaMundoE(){
        return "Hello World";
    }

    /**Los navegadores usan GET: traer páginas web, POST: rellenamos formulario, PUT, DELETE y OPTIONS
     * GET en la dirección y POST van ocultos (passwords)
     * http://localhost:8080/?param=pepe&param2=juan
     * llamada a localhost:8080 pero pasando dos parámetros
     * http://localhost:8080/?nombre=pepe
     * 
     * 
    */


}