package com.learn.artemismq.api;
import com.learn.artemismq.model.MsTemplateMessage;
import com.learn.artemismq.producer.ArtemisProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
@RequestMapping(value = "/artemis")
public class MessageController {

    private ArtemisProducer artemisProducer;

    @Autowired
    public MessageController(ArtemisProducer artemisProducer){
        this.artemisProducer = artemisProducer;
    }


    @PostMapping(value = "/send")
    public ResponseEntity<String> send (@RequestBody MsTemplateMessage msTemplateMessage){
        try{
         artemisProducer.publishMessage(msTemplateMessage);
        }catch (Exception e){
           log.error("Send message failed: "+msTemplateMessage.toString(),e);
           return new ResponseEntity<>("Failed to send message: "+msTemplateMessage.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Succeed to send message: "+msTemplateMessage.toString(), HttpStatus.OK);
    }

}
