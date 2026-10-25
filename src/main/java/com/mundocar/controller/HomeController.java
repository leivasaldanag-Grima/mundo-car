package com.mundocar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/** Permite ingresar desde /inicio además del index estático. */
@Controller
public class HomeController {
    @GetMapping("/inicio")
    public String inicio() { return "forward:/index.html"; }
}
