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

    private static final Logger logger = LoggerFactory.getLogger(SendController.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    // curl -X POST 'http://localhost:8080/messages?dest=sbonilla-demo&message=hithere'
    @PostMapping("/messages")
    public String postMessage(@RequestParam String dest, @RequestParam String message) {
        logger.info("Sending message");
        jmsTemplate.convertAndSend(dest, new User(message));
        return message;
    }
    /*
        dest is the service bus name (destination), which can either be a queue or topic.
        Queue = sbonilla-demo
        Topic = senj-input
     */
    // curl -X POST 'http://localhost:8080/sendtotopic?dest=senj-input&message=hey'
    @PostMapping("/sendtotopic")
    public String postToTopic(@RequestParam String dest, @RequestParam String message) {
        logger.info("Posting to topic");
        jmsTemplate.convertAndSend(dest, new User(message));
        return message;
    }

    @RequestMapping("/healthcheck")
    public String index() {
        logger.info("ran health check");
        return "Hello world, application healthy";
    }
}