package com.learn.artemismq.producer;
import com.learn.artemismq.model.MsTemplateMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;



@Slf4j
@Service
public class AmqProducer implements IQueueProducer{


    @Value("${spring.activemq.queue.name}")
    private String queueName;

    private JmsTemplate jmsTemplate;

    @Autowired
    public AmqProducer(@Qualifier("activeMqJmsTemplate") JmsTemplate jmsTemplate){
        this.jmsTemplate=jmsTemplate;
    }


    @Override
    public void publishMessage(String operation, String data) {
        MsTemplateMessage msTemplateMessage=new MsTemplateMessage(operation,data);
        log.info("PUBLISH MESSAGE -> "+msTemplateMessage.toString());
        jmsTemplate.convertAndSend(queueName, msTemplateMessage);
    }


}

