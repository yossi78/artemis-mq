package com.learn.artemismq.producer;
import com.learn.artemismq.model.BaseMessage;



public interface IQueueProducer {

    public void produceMessage(BaseMessage baseMessage);

}
