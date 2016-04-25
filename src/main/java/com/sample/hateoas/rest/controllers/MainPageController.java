package com.sample.hateoas.rest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrador on 4/4/2016.
 */

@RestController
@RequestMapping("/api/mainpage")
public class MainPageController {

    @RequestMapping(method = RequestMethod.GET)
    public String getMainPage() {
        return "I am in the main page after login";
    }
}
