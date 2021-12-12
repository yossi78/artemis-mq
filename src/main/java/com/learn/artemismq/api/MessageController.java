package com.learn.artemismq.api;
import com.learn.artemismq.model.BaseMessage;
import com.learn.artemismq.model.MsTemplateMessage;
import com.learn.artemismq.producer.ProducerService;
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

    private ProducerService despacherService;

    @Autowired
    public MessageController(ProducerService despacherService){
        this.despacherService=despacherService;
    }


    @PostMapping(value = "/send")
    public ResponseEntity<String> send (@RequestBody MsTemplateMessage msTemplateMessage){
        try{
         despacherService.sendMessage(msTemplateMessage);
        }catch (Exception e){
           log.error("Send message failed: "+msTemplateMessage.toString(),e);
           return new ResponseEntity<>("Failed to send message: "+msTemplateMessage.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Succeed to send message: "+msTemplateMessage.toString(), HttpStatus.OK);
    }

}
