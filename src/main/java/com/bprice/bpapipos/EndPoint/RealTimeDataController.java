package com.bprice.bpapipos.EndPoint;

import com.bprice.persistance.model.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
@EnableScheduling
public class RealTimeDataController {
    @Autowired
    private SimpMessagingTemplate template;


    @Scheduled(fixedRate = 5000)
    @MessageMapping("/hello")
    public void greeting() throws Exception {

        Thread.sleep(1000);
        System.out.println(new Hello("Hi sex"));
        this.template.convertAndSend("/topic/hi","Hi, sex");
    }
}
