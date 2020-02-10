package com.josenavarro.holaspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * MainController
 */

@Controller
public class MainController{
    @GetMapping("/") // Entradas en la tabla de rutas solo una por dirección, ejecuta el método de abajo al encontrar "/" es la ruta servidor
    @ResponseBody // Busca plantilla timeleaf que responde el nombre que le pongamos
    public String holaMundo(@RequestParam("nombre") String name, @RequestParam("edad") Integer edad){ /** Request es la petición y Response la respuesta, lo captura y lo guarad en el String name */
        return "Hola "+name+", edad "+edad; // http://localhost:8080/?nombre=Jose&edad=36
    }
    
    @GetMapping("/ingles") // Entradas en la tabla de rutas solo una por dirección
    @ResponseBody // Busca plantilla timeleaf que responde el nombre que le pongamos
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

    /**Qué es lo que hace timeleef
     * La llamada GET desde el navegador va al controlador (controller), y spring va a usar la vista
     * y esta te genere el html para devolver, y este html será enviado. Esta vista en timeleaf hace 
     * plantillas en HTML para ver cómo es la vista.
     * En resources spring boot lo gestiona por defecto, static(css, javascript, fotos, etc) y templates:
     * donde va a guardar las plantillas de timeleaf
     * 
     */

     
    //Devolver página con templates
    @GetMapping("/nuevo")
    public ModelAndView helloHTML(){
        ModelAndView respuesta = new ModelAndView("hello");//nombre del template
        String msg = "hola mundo html";
        respuesta.addObject("mensaje", msg);
        return respuesta;
    }

    //Calculadora
    @GetMapping("/calculadora")
    @ResponseBody
    public String calculadora(@RequestParam("Operador") String operador, @RequestParam("Operando1") Double operando1, @RequestParam(value = "Operando2", required = false) Double operando2){
        String frase = operando1 + operador + operando2;
        double res = 0.0;
        switch(operador){
            case "-":
            res = operando1-operando2;
            frase = frase + "=" + res;
            break;

            case "sum":
            res = operando1+operando2;
            frase = frase + "=" + res;
            break;

            case "*":
            res = operando1*operando2;
            frase = frase + "=" + res;
            break;

            case "/":
            res = operando1/operando2;
            frase = frase + "=" + res;
            break;

            case "cuadrado":
            frase = operando1 + operador;
            res = operando1*operando1;
            frase = frase + "=" + res;
            break;

            case "sqrt":
            frase = operando1 + operador;
            res = Math.sqrt(operando1);
            frase = frase + "=" + res;
            break;
            
            default:
            return "Ha habido algun error";
        }
        return frase;
    }
}