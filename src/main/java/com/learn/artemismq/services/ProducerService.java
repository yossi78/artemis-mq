package com.learn.artemismq.services;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;



@Service
@Slf4j
public class ProducerService {

    @Value("${artemis.jms.queue}")
    private String artemisJmsQueue;


    private JmsTemplate jmsTemplate;

    @Autowired
    public ProducerService(JmsTemplate jmsTemplate){
        this.jmsTemplate=jmsTemplate;
    }


    public void sendMessage(String message){
        log.info("PUBLISH MESSAGE -> "+message);
        jmsTemplate.convertAndSend(artemisJmsQueue,message);
    }

}
