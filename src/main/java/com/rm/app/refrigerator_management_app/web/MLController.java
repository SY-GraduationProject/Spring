package com.rm.app.refrigerator_management_app.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MLController {
    @RequestMapping(value = "/ml")
    public String ml_test() {
        return "ml";
    }
}
