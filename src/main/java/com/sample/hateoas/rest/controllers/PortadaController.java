package com.sample.hateoas.rest.controllers;

import com.sample.hateoas.core.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by andresmerida on 4/4/2016.
 */

@RestController
@RequestMapping("/")
public class PortadaController {

    private final static Logger log = LoggerFactory.getLogger(PortadaController.class);

    @Autowired
    UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String greeting() {
        return "Hello World!";
    }
}
