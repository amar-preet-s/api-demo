package com.example.demo.course;


import com.example.demo.data.data;
import com.example.demo.service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;

@RestController
public class course {
    @Autowired
    private service serv;


    @GetMapping("/api/shorten")
    public ArrayList<data> Shorten(@RequestParam(required = false) String longURL) {
        return serv.getcode(longURL);
    }

    @GetMapping("/api/expand")
    public ArrayList<data> Expand(@RequestParam(required = false) String shortURL) {
        return serv.geturl(shortURL);
    }

    @GetMapping("/api/analytics")
    public ArrayList<data> Analytics() {
        return serv.getAnalytics();
    }

}
