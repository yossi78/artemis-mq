package com.learn.artemismq.config;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import javax.jms.ConnectionFactory;



@Configuration
@EnableJms
public class ArtemisConfig {


    @Value("${spring.artemis.broker-url}")
    private String brokerUrl;


    @Value("${spring.activemq.concurrency}")
    private String concurrency;


    @Bean(value = "artemisMqFactory")
    public org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory senderActiveMQConnectionFactory() {
        org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory factory= new org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory(brokerUrl);
        return factory;
    }

    @Bean(value = "artemisMqJmsTemplate")
    public JmsTemplate jmsTemplate() {
        return new JmsTemplate(cachingConnectionFactory());
    }

    @Bean(value = "artemisMqCachingConnectionFactory")
    public CachingConnectionFactory cachingConnectionFactory() {
        return new CachingConnectionFactory(senderActiveMQConnectionFactory());
    }

    @Bean(value = "artemisMqJmsListenerContainerFactory")
    public org.springframework.jms.config.DefaultJmsListenerContainerFactory jmsListenerContainerFactory(@Qualifier(value = "artemisMqFactory") ConnectionFactory connectionFactory){
        org.springframework.jms.config.DefaultJmsListenerContainerFactory jmsListenerContainerFactory=new org.springframework.jms.config.DefaultJmsListenerContainerFactory();
        jmsListenerContainerFactory.setConnectionFactory(connectionFactory);
        jmsListenerContainerFactory.setConcurrency(concurrency);
        return jmsListenerContainerFactory;
    }



}

