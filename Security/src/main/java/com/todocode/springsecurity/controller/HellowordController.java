package com.todocode.springsecurity.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("denyALL()")
public class HellowordController {

    @GetMapping("/holaseg")
    @PreAuthorize("hasRole('USER')")
    public String secHelloWord() {

        return "hola mundo con seguridad";
    }

    @GetMapping("/holanoseg")
    @PreAuthorize("permitAll()")
    public String noSecHelloWord() {

        return "hola mundo SIN seguridad";
    }


}
