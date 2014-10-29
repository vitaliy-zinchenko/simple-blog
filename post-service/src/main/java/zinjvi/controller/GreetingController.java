package zinjvi.controller;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import zinjvi.bean.Bean;


@Controller
 public class GreetingController {


     @MessageMapping("/hello")
     @SendTo("/topic/greetings")
     public Bean greeting(Bean message) throws Exception {
         Thread.sleep(3000); // simulated delay
         return new Bean("Hello, " + message.getName() + "!");
     }

 }
