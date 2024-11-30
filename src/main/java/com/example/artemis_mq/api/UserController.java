package com.example.artemis_mq.api;
import com.example.artemis_mq.entity.UserEntity;
import com.example.artemis_mq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserEntity user) {
        userService.addUser(user);
        return ResponseEntity.ok("Message added to the queue!");
    }

    @GetMapping
    public ResponseEntity<UserEntity> consumeUser() {
        UserEntity user = userService.getNextUser();
        return ResponseEntity.ok(user);
    }
}
