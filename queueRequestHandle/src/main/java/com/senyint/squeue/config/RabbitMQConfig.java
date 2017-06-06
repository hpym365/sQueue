//package com.senyint.queue.config;
//
//import com.senyint.squeue.consumer.Receive;
//import org.springframework.amqp.core.*;
//import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
//import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.support.BeanDefinitionBuilder;
//import org.springframework.beans.factory.support.DefaultListableBeanFactory;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
//@Configuration
//public class RabbitMQConfig {
//
//    public static final String EXCHANGE = "recive_exchange";
//
//    public static final String ROUTING_KEY = "recive_key";
//
//
////    @Bean
////    public DirectExchange defaultExchange() {
////        return new DirectExchange(EXCHANGE, true, false);
////    }
////
////    @Bean
////    public Queue squeue() {
////        return new Queue("recive_queue", true); //队列持久
////    }
////
////    @Bean
////    public Binding binding() {
////        return BindingBuilder.bind(squeue()).to(defaultExchange()).with(RabbitMQConfig.ROUTING_KEY);
////    }
//
//
//
////    @Bean
////    public Queue queue1() {
////        return new Queue("recive_queue1", true); //队列持久
////    }
//
////    @Bean
////    public Binding binding1() {
////        return BindingBuilder.bind(queue1()).to(defaultExchange()).with(RabbitMQConfig.ROUTING_KEY);
////    }
//
////    @Bean
////    @Qualifier("ffff")
////    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
////                                             ChannelAwareMessageListener listenerAdapter) {
////        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
////        container.setConnectionFactory(connectionFactory);
////        container.setQueueNames("recive_queue");
////        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
////        container.setMessageListener(listenerAdapter);
////        return container;
////    }
//
//
//    @Bean
//    public Object dynamicBeanConfiguration(ApplicationContext applicationContext, ConnectionFactory connectionFactory) throws Exception {
//        ConfigurableApplicationContext context = (ConfigurableApplicationContext) applicationContext;
//        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) context.getBeanFactory();
//
////        DirectExchange directExchange = new DirectExchange(EXCHANGE, true, false);
////        Queue q = new Queue("recive_queue");
////        Binding b = BindingBuilder.bind(q).to(directExchange).with(RabbitMQConfig.ROUTING_KEY);
////        //Queue1
////        BeanDefinitionBuilder q1 = BeanDefinitionBuilder.rootBeanDefinition(Queue.class);
////        /**
////         * 设置属性
////         */
////        q1.addPropertyValue("name", "recive_queue1");
////        q1.addPropertyValue("durable", true);
////        /**
////         * 注册到spring容器中
////         */
////        beanFactory.registerBeanDefinition("q1", q1.getBeanDefinition());
//
//        //反射  每次生成新的
//        Class c = Class.forName("com.senyint.squeue.consumer.Receive");
//        Object o = c.newInstance();
//
//        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(SimpleMessageListenerContainer.class);
//        /**
//         * 设置属性
//         */
//
//        //在spring上下文中获得
//        Object messageListener =  applicationContext.getBean("receive");
//        Object messageListener1 =  applicationContext.getBean("receive");
//
//        if(!(messageListener instanceof MessageListener) && !(messageListener instanceof ChannelAwareMessageListener)) {
//            throw new IllegalArgumentException("Message listener needs to be of type [" + MessageListener.class.getName() + "] or [" + ChannelAwareMessageListener.class.getName() + "]");
//        }
//
//        beanDefinitionBuilder.addPropertyValue("connectionFactory", connectionFactory);
//        beanDefinitionBuilder.addPropertyValue("queueNames", "recive_queue");
//        beanDefinitionBuilder.addPropertyValue("messageListener", o);
//        beanDefinitionBuilder.addPropertyValue("acknowledgeMode", AcknowledgeMode.MANUAL);
//        /**
//         * 注册到spring容器中
//         */
//        beanFactory.registerBeanDefinition("userService", beanDefinitionBuilder.getBeanDefinition());
//
//        return null;
//    }
//
////    @Bean
////    MessageListenerAdapter listenerAdapter(Receive receiver) {
////        return new MessageListenerAdapter(receiver, "receiveMsg");
////    }
//
////    @Bean
////    ChannelAwareMessageListener jjj(){
////        return new Receive();
////    }
//
//}
