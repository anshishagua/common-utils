package com.anshishagua.controller;

import org.apache.spark.storage.BlockManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/event-analyze")
public class EventAnalyzeController {

    @RequestMapping("")
    public String index() {
        return "hello";
    }
}
