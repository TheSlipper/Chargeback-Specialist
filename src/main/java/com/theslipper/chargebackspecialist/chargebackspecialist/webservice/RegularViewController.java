package com.theslipper.chargebackspecialist.chargebackspecialist.webservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegularViewController {

    @RequestMapping("/")
    String home() {
        return "<h1>Hello world!</h1>";
    }

}
