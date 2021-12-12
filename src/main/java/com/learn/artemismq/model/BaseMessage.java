package com.learn.artemismq.model;
import lombok.*;
import java.io.Serializable;



@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class BaseMessage implements IMsTemplateMessage, Serializable {

    protected String operation;
    protected String message;


}


