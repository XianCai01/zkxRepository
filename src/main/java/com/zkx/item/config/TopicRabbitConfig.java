package com.zkx.item.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitConfig {

    private final static String man = "topic.man";
    private final static String woman = "topic.woman";

    @Bean
    public Queue firstQueue(){
        return new Queue(TopicRabbitConfig.man);
    }

    @Bean
    public Queue secondQueue(){
        return new Queue(TopicRabbitConfig.woman);
    }

    @Bean
    TopicExchange exchange(){
        return new TopicExchange("topicExchange");
    }

    /**
     * 将firstQueue与topicExchange绑定，并且绑定的键值为 topic.man
     * 这样 只要是消息携带的路由键是topic.man  才会被分发到该队列
     * @return
     */
    @Bean
    Binding bindingExchangeMessage1(){
        return BindingBuilder.bind(firstQueue()).to(exchange()).with(man);
    }

    /**
     * 将secondQueue与topicExchange绑定，而且绑定的键值为用上通配路由规则topic.#
     * 这样只要消息携带的路由键是以topic.开头，都会分发到该队列
     * @return
     */
    @Bean
    Binding bindingExchangeMessage2(){
        return BindingBuilder.bind(secondQueue()).to(exchange()).with("topic.#");
    }
}
