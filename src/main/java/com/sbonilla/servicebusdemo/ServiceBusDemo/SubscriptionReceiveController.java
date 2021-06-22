package com.sbonilla.servicebusdemo.ServiceBusDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionReceiveController {

    private static final String TOPIC_NAME = "senj-input"; // ServiceBusTopicName

    private static final String SUBSCRIPTION_NAME = "steven-listener"; // ServiceBusSubscriptionName

    private final Logger logger = LoggerFactory.getLogger(SubscriptionReceiveController.class);

    @JmsListener(destination = TOPIC_NAME, containerFactory = "topicJmsListenerContainerFactory",
            subscription = SUBSCRIPTION_NAME)
    public void receiveMessage(User user) {
        logger.info("Received message: {}", user.getName());
    }
}