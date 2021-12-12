package com.learn.artemismq.consumer;


import com.learn.artemismq.model.BaseMessage;

public interface IQueueConsumer {

    public void receiveMessage(BaseMessage baseMessage);

}
