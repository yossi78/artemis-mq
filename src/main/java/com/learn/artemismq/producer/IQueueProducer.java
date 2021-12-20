package com.learn.artemismq.producer;


public interface IQueueProducer {

    public void publishMessage(String operation, String data);

}
