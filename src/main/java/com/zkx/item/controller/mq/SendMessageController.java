package com.zkx.item.controller.mq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class SendMessageController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("/sendDirectMessage")
    public String sendDirectMessage(){
        String messageId=String.valueOf(UUID.randomUUID());
        String messageData="the first message : hello world!";
        String createTime= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String,Object> map=new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",messageData);
        map.put("createTime",createTime);
        //将消息携带绑定键值：bindingDirect  发送到交换机：directExchange
        rabbitTemplate.convertAndSend("directExchange","bindingDirect",map);
        return "OK";
    }

    @GetMapping("/sendTopicMessage1")
    public String sendTopicMessage1(){
        String messageId=String.valueOf(UUID.randomUUID());
        String messageData="topic message : M A N!";
        String createTime= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String,Object> manMap=new HashMap<>();
        manMap.put("messageId",messageId);
        manMap.put("messageData",messageData);
        manMap.put("createTime",createTime);
        //将消息携带绑定键值：topic.man  发送到交换机：topicExchange
        rabbitTemplate.convertAndSend("topicExchange","topic.man",manMap);
        return "OK";
    }

    @GetMapping("/sendTopicMessage2")
    public String sendTopicMessage2(){
        String messageId=String.valueOf(UUID.randomUUID());
        String messageData="topic message : WOMAN IS ALL!";
        String createTime= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String,Object> womanMap=new HashMap<>();
        womanMap.put("messageId",messageId);
        womanMap.put("messageData",messageData);
        womanMap.put("createTime",createTime);
        //将消息携带绑定键值：topic.man  发送到交换机：topicExchange
        rabbitTemplate.convertAndSend("topicExchange","topic.woman",womanMap);
        return "OK";
    }

    @GetMapping("/sendFanoutMessage")
    public String sendFanoutMessage(){
        String messageId=String.valueOf(UUID.randomUUID());
        String messageData="fanout message : my is fanoutExchange!";
        String createTime= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String,Object> map=new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",messageData);
        map.put("createTime",createTime);
        //将消息携带绑定键值：topic.man  发送到交换机：topicExchange
        rabbitTemplate.convertAndSend("fanoutExchange",null,map);
        return "OK";
    }
}
