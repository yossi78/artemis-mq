package com.learn.artemismq.consumer;
import com.learn.artemismq.model.BaseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;



@Service
@Slf4j
public class ArtemisConsumer implements IQueueConsumer{


    @Override
    @JmsListener(destination = "${artemis.jms.queue}")
    public void consumeMessage(BaseMessage baseMessage) {
        log.info("RECIEVE MESSAGE: " + baseMessage.toString());
    }
}
