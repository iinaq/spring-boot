package com.iinaq.springboot.controller;

import com.iinaq.springboot.utils.WebSocketUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class ChatRoomController {

    @GetMapping("/chat-room/{sender}/to/{receive}")
    public void onMessage(@PathParam("sender") String sender,@PathParam("receive") String receive,String message){
        WebSocketUtils.sendMessage(WebSocketUtils.LIVING_SESSION_CACHE.get(receive),sender+"->"+receive+":"+message );
    }
}
