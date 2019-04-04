package com.triplepack.cable.commands;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
class GreetingController {
    private static final Logger LOG = Logger.getLogger(GreetingController.class.getName());

    @RequestMapping("/telebosta")
    public String getGreeting(){
        LOG.info("La concha de tu hermana All Boys");
        return "Sarasa!!!";
    }
}