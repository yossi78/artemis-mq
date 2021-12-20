package com.learn.artemismq.producer;
import com.learn.artemismq.model.BaseMessage;
import com.learn.artemismq.model.MsTemplateMessage;


public interface IQueueProducer {

    public void publishMessage(MsTemplateMessage msTemplateMessage);

}
