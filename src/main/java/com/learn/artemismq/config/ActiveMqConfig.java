package com.learn.artemismq.config;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import javax.jms.ConnectionFactory;


@Configuration
@EnableJms
public class ActiveMqConfig {


    @Value("${spring.activemq.broker-url}")
    private String brokerUrl;


    @Value("${spring.activemq.concurrency}")
    private String concurrency;


    @Bean(value = "activeMqFactory")
    public org.apache.activemq.ActiveMQConnectionFactory senderActiveMQConnectionFactory() {
        org.apache.activemq.ActiveMQConnectionFactory factory= new org.apache.activemq.ActiveMQConnectionFactory(brokerUrl);
        factory.setTrustAllPackages(true);
        return factory;
    }

    @Bean(value = "activeMqJmsTemplate")
    public JmsTemplate jmsTemplate() {
        return new JmsTemplate(cachingConnectionFactory());
    }

    @Bean(value = "activeMqCachingConnectionFactory")
    public CachingConnectionFactory cachingConnectionFactory() {
        return new CachingConnectionFactory(senderActiveMQConnectionFactory());
    }

    @Bean(value = "activeMqJmsListenerContainerFactory")
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(@Qualifier(value = "activeMqFactory") ConnectionFactory connectionFactory){
        DefaultJmsListenerContainerFactory jmsListenerContainerFactory=new DefaultJmsListenerContainerFactory();
        jmsListenerContainerFactory.setConnectionFactory(connectionFactory);
        jmsListenerContainerFactory.setConcurrency(concurrency);
        return jmsListenerContainerFactory;
    }



}


