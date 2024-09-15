package com.city.mode.controller;

import com.city.mode.model.MyModel;
import com.city.mode.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {



        @Autowired
        private MyService myService;

        @GetMapping("/items")
        public List<MyModel> getAllItems() {
            return myService.getAllItems();
        }

        @PostMapping("/items")
        public MyModel createItem(@RequestBody MyModel myModel) {
            return myService.createItem(myModel);
        }
    }

