package com.learn.artemismq.producer;
import com.learn.artemismq.model.BaseMessage;
import com.learn.artemismq.model.MsTemplateMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;




@Service
@Slf4j
public class ArtemisProducer implements IQueueProducer{

    @Value("${artemis.jms.queue}")
    private String artemisJmsQueue;


    private JmsTemplate jmsTemplate;

    @Autowired
    public ArtemisProducer(@Qualifier(value = "artemisMqJmsTemplate") JmsTemplate jmsTemplate){
        this.jmsTemplate=jmsTemplate;
    }


    @Override
    public void publishMessage(MsTemplateMessage msTemplateMessage) {
        log.info("PUBLISH MESSAGE -> "+msTemplateMessage.toString());
        jmsTemplate.convertAndSend(artemisJmsQueue,msTemplateMessage);
    }
}
