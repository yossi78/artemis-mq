package com.learn.artemismq.services;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;



@Service
@Slf4j
public class ConsumerService {


    @JmsListener(destination = "${artemis.jms.queue}")
    public void receiveMessage(String message){
        log.info("RECIEVE MESSAGE: " +message);
    }


}
