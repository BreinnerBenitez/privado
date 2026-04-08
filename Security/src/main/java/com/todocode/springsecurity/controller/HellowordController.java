package com.todocode.springsecurity.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HellowordController {

    @GetMapping("/holaseg")
    public String secHelloWord() {

        return "hola mundo con seguridad";
    }

    @GetMapping("/holanoseg")
    public String noSecHelloWord() {

        return "hola mundo SIN seguridad";
    }


}
