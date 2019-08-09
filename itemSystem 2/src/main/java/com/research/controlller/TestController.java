package com.research.controlller;

import com.research.configuration.JdbcConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/test")
public class TestController {
    @Autowired
    JdbcConfigBean jdbcConfigBean;
    @GetMapping("index")
    public String index(Model m) {
        m.addAttribute("text", "test success!");
        return "index";
    }

    @GetMapping(value = "testconfig")
    public String testconfig(){
        return this.jdbcConfigBean.toString();
    }
}
