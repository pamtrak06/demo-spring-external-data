package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.example.demo.services.ServiceLoader;

@RestController
public class DemoController {

    @Autowired
    ServiceLoader serviceLoader;

    @GetMapping(path = "/load", produces = MediaType.APPLICATION_JSON_VALUE)
    public String loadData() throws Exception {
        return serviceLoader.loadData().toString() + "<br />" + serviceLoader.loadData().getInputStream();
    }
    
    
}