/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nakul.shah.hellospring4rest;

/**
 *
 * @author V506617
 */

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GreetingController 
{
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) 
    {
        String uri = "http://localhost:8080/arrived?name=" + name;
     
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject(uri, String.class);
        
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
