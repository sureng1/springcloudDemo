package com.research.controlller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/test")
public class TestController {
    @GetMapping("index")
    public String index(Model m) {
        m.addAttribute("text", "test success!");
        return "index";
    }
}
