package com.sbonilla.servicebusdemo.ServiceBusDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendController {

    private static final String DESTINATION_NAME = "sbonilla-demo";

    private static final Logger LOGGER = LoggerFactory.getLogger(SendController.class);

    @Autowired
    private JmsTemplate jmsTemplate;



    /*
    @PostMapping("/messages")
    public String postMessage(@RequestParam String message) {
        LOGGER.info("Sending message");
        jmsTemplate.convertAndSend(DESTINATION_NAME, new User(message));
        return message;
    }

    */

    @RequestMapping("/healthcheck")
    public String index() {
        return "Hello world, application healthy";
    }
}