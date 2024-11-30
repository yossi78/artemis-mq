package com.example.artemis_mq.message;
import com.example.artemis_mq.entity.UserEntity;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    private UserEntity nextMessage;

    @JmsListener(destination = "user.queue")
    public void receiveMessage(UserEntity user) {
        nextMessage = user;
    }

    public UserEntity getNextMessage() {
        return nextMessage;
    }
}
