package com.learn.artemismq.model;
import java.io.Serializable;




public class MsTemplateMessage extends BaseMessage implements Serializable {


    public MsTemplateMessage (String operation, String message) {
        super(operation,message);
    }


}