package com.learn.artemismq.api;
import com.learn.artemismq.services.ProducerService;
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
    public ResponseEntity<String> send (@RequestBody String message){
        try{
         despacherService.sendMessage(message);
        }catch (Exception e){
           log.error("Send message failed: "+message,e);
           return new ResponseEntity<>("Failed to send message: "+message, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Succeed to send message: "+message, HttpStatus.OK);
    }

}
