package com.bprice.bpapipos.EndPoint;

import com.bprice.persistance.model.Hello;
import com.bprice.persistance.model.User;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class RealTimeDataController {
    @MessageMapping("/hello")
    @SendTo("/topic/hi")
    public Hello greeting(User user) throws Exception {
        System.out.println(new Hello("Hi, " + user.getName() + "!"));

        return new Hello("Hi, " + user.getName() + "!");
    }
}
