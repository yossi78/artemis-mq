package com.example.artemis_mq.message;
import com.example.artemis_mq.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(UserEntity user) {
        jmsTemplate.convertAndSend("user.queue", user);
    }
}
