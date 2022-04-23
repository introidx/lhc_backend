package com.introidx.controlers;

import com.introidx.lhc_backend.domain.chat.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;

/**
 * Created by PRAKASH RANJAN on 21-04-2022
 */

@Controller
@CrossOrigin(origins = {"http://localhost:3000"})
public class MessageController {

    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    public Message receiveMessage(@Payload Message message){
        return message;
    }
}
