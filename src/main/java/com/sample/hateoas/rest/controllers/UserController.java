package com.sample.hateoas.rest.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sample.hateoas.core.entities.User;
import com.sample.hateoas.core.repositories.UserRepository;

import java.util.List;

/**
 * Created by andresmerida on 4/4/2016.
 */

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final static Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity <List<User>> getUsers() {
        // a way optain information about current user
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String username = ((UserDetails)principal).getUsername();
            log.info("current user: " + username+ ", current password: "
                    + ((UserDetails)principal).getPassword());
        } else {
            String username = principal.toString();
            log.info("UserName 2 = " + username);
        }

        return new ResponseEntity<> (userRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}
