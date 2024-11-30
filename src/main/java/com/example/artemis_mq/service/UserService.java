package com.example.artemis_mq.service;
import com.example.artemis_mq.entity.UserEntity;
import com.example.artemis_mq.message.MessageConsumer;
import com.example.artemis_mq.message.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private MessageProducer messageProducer;

    @Autowired
    private MessageConsumer messageConsumer;

    public void addUser(UserEntity user) {
        messageProducer.sendMessage(user);
    }

    public UserEntity getNextUser() {
        return messageConsumer.getNextMessage();
    }
}
