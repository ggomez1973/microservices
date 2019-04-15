package com.triplepack.cable.commands;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@EnableBinding(Sink.class)
class GreetingController {
    private static final Logger LOG = Logger.getLogger(GreetingController.class.getName());

    @RequestMapping("/telebosta")
    public String getGreeting(){
        handle("fuckersss!");
        LOG.info("La concha de tu hermana All Boys");
        return "Sarasa!!!";
    }

    @StreamListener(Sink.INPUT)
    public void handle(String string){
        System.out.println("Received: " + string);
    }
}