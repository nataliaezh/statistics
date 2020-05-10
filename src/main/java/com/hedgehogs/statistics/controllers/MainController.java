package com.hedgehogs.statistics.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author natalya_ezhkova@mail.ru
 */
@Controller
public class MainController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
