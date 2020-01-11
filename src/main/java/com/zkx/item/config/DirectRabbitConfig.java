package com.zkx.item.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 *  @author: ZhaoKeXian
 *  @Date: 2020-01-9, 周四, 18:34
 *  @Description: 直连型交换机 配置文件
 */
@Configuration
public class DirectRabbitConfig {
    /**
     * 队列 起名：directQueue
     * @return
     */
    @Bean
    public Queue directQueue(){
        return new Queue("directQueue",true);
    }//true：是否持久

    /**
     * Direct 交换机  起名：directExchange
     * @return
     */
    @Bean
    DirectExchange directExchange(){
        return new DirectExchange("directExchange");
    }

    /**
     *绑定    将队列和交换机进行绑定，并设置用于匹配键：bindingDirect
     * @return
     */
    @Bean
    Binding bindingDirect(){
        return BindingBuilder.bind(directQueue()).to(directExchange()).with("bindingDirect");
    }
}
