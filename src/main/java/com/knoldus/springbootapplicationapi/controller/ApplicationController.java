package com.knoldus.springbootapplicationapi.controller;

import com.knoldus.springbootapplicationapi.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {
    //injecting AppService object
    @Autowired
    ApplicationService appService;
    @RequestMapping("/status_time")
    public String getStatusWithTime(){
        return appService.getStatusWithTime();
    }
}
