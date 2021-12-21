package com.learn.artemismq.consumer;
import com.learn.artemismq.model.BaseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;



@Slf4j
@Component
public class AmqConsumer implements IQueueConsumer{



    @Override
    @JmsListener(destination = "${spring.activemq.queue.name}",containerFactory = "activeMqJmsListenerContainerFactory")
    public void messageListener(BaseMessage baseMessage) {
        log.info("CONSUME_MESSAGE="+baseMessage.toString());
    }

}
