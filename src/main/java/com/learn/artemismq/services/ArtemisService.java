package com.learn.artemismq.services;
import com.learn.artemismq.config.ActiveMqConfig;
import com.learn.artemismq.producer.AmqProducer;
import com.learn.artemismq.producer.ArtemisProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ArtemisService {

    private ArtemisProducer artemisProducer;
    private AmqProducer amqProducer;


    @Autowired
    public ArtemisService(ArtemisProducer artemisProducer, AmqProducer amqProducer) {
        this.artemisProducer = artemisProducer;
        this.amqProducer = amqProducer;
    }

    public void publishMessage(String operation, String data){
       amqProducer.publishMessage(operation, data);
       artemisProducer.publishMessage(operation,data);
    }

}
