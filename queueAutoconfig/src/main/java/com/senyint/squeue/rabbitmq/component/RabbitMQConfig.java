package com.senyint.squeue.rabbitmq.component;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @Title Rabbit mq config
 * @Version 1.0
 * @Date 20170518 09:03:13
 * @Author hpym365@gmail.com
 * @Description MQautoconfig
 */
@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE = "recive_exchange";

    public static final String ROUTING_KEY = "recive_key";

    @Autowired
    private RabbitMQBean mq;

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    ConnectionFactory connectionFactory;


    /**
     * @param applicationContext the application context
     * @param connectionFactory  the connection factory
     * @return null
     * @throws Exception the exception
     * @Version 1.0
     * @Date 20170518 23:07:09
     * @Author hpym365 @gmail.com
     * @Description Config  rabbit mq Binds Register Queue Exchange Binding.
     */
    @Bean
    public Object configRabbitMQBinds(ApplicationContext applicationContext, ConnectionFactory connectionFactory)
            throws Exception {

//        try{
//            Channel channel = connectionFactory.createConnection().createChannel(false);
//            channel.exchangeDelete("receive_exchange");
//        }catch (Exception ex){
//
//        }
        List<Map<String, String>> binds = mq.getBinds();
        if(binds==null)
            return null;
        binds.forEach(new Consumer<Map<String, String>>() {
            @Override
            public void accept(Map<String, String> map) {
                String exchangeName = map.get("exchange");
                if (exchangeName == null)
                    throw new IllegalArgumentException("yaml文件配置错误,squeue.mq.binds配置不正确找不到exchange参数");
                String type = map.get("type") == null ? "" : map.get("type");
                String queueName = map.get("squeue");
                String routingKey = map.get("routingkey");
                Queue queue = null;
                if (queueName != null) {
                    queue = new Queue(queueName);
                    registerSingletonBean(queueName, queue);
                }

                switch (type) {
                    case "fanout": {
                        FanoutExchange exchange = new FanoutExchange(exchangeName, true, false);
                        registerSingletonBean(exchangeName, exchange);
                        if (queue != null) {
                            Binding bind = BindingBuilder.bind(queue).to(exchange);
                            registerSingletonBean(queueName + exchangeName, bind);
                        }
                        break;
                    }
                    case "topic": {
                        TopicExchange exchange = new TopicExchange(exchangeName, true, false);
                        registerSingletonBean(exchangeName, exchange);
                        if (queue != null) {
                            Binding bind = BindingBuilder.bind(queue).to(exchange).with(routingKey);
                            registerSingletonBean(queueName + exchangeName, bind);
                        }
                        break;
                    }
                    default: {
                        DirectExchange exchange = new DirectExchange(exchangeName, true, false);
                        registerSingletonBean(exchangeName, exchange);
                        if (queue != null) {
                            Binding bind = BindingBuilder.bind(queue).to(exchange).with(routingKey);
                            registerSingletonBean(queueName + exchangeName, bind);
                        }
                    }
                }


            }
        });

        return null;
    }


    /**
     * @param applicationContext the application context
     * @param connectionFactory  the connection factory
     * @return the object
     * @throws Exception the exception
     * @Version 1.0
     * @Date 20170519 00:41:27
     * @Author hpym365 @gmail.com
     * @Description Config  rabbit mq consumer object.
     */
    @Bean
    public Object configRabbitMQConsumer(ApplicationContext applicationContext, ConnectionFactory connectionFactory)
            throws Exception {

        List<Map<String, String>> consumer = mq.getConsumer();
        if(consumer==null)
            return null;
        consumer.forEach(new Consumer<Map<String, String>>() {
            @Override
            public void accept(Map<String, String> map) {
                String queue = map.get("squeue");
                String listener = map.get("listener");
                if(queue==null || listener==null)
                    throw new IllegalArgumentException("yaml文件配置错误,squeue.mq.consumer配置不正确找不到queue或listener参数");

                Object messageListener = applicationContext.getBean("receive");
                if (!(messageListener instanceof MessageListener) && !(messageListener instanceof ChannelAwareMessageListener)) {
                    throw new IllegalArgumentException("yaml文件配置错误,配置的listener [" + MessageListener.class.getName() + "] or [" + ChannelAwareMessageListener.class.getName() + "]错误");
                }

                SimpleMessageListenerContainer s = new SimpleMessageListenerContainer();
                s.setAcknowledgeMode(AcknowledgeMode.MANUAL);
                s.setQueueNames(queue);
                s.setConnectionFactory(connectionFactory);
                s.setMessageListener(messageListener);
                s.setConcurrentConsumers(10);

                registerSingletonBean(queue+listener.toString(),s);
            }
        });


        /**
         * 注册到spring容器中
         */
//        beanFactory.registerBeanDefinition("userService", beanDefinitionBuilder.getBeanDefinition());


        return null;
    }

    /**
     * @param beanName the bean name
     * @param object   the object
     * @Version 1.0
     * @Date 20170518 23:07:09
     * @Author hpym365 @gmail.com
     * @Description Register  singleton bean.
     */
    public void registerSingletonBean(String beanName, Object object) {
        ConfigurableApplicationContext context = (ConfigurableApplicationContext) applicationContext;
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) context.getBeanFactory();
        try {
            beanFactory.getBean(beanName);
            System.out.println("Bean已经被注册了：" + beanName + "  " + beanFactory.getBean(beanName));
        } catch (Exception ex) {
            beanFactory.registerSingleton(beanName, object);
            System.out.println("成功注册bean" + beanName);
        }
    }



//    @Bean
//    public Object dynamicBeanConfiguration(ApplicationContext applicationContext, ConnectionFactory connectionFactory)
//            throws Exception {
//
//        System.out.println("test111111111111:" + cccc);
//        ConfigurableApplicationContext context = (ConfigurableApplicationContext) applicationContext;
//        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) context.getBeanFactory();
//
//        DirectExchange directExchange = new DirectExchange("recive_exchange", true, false);
//        Queue q = new Queue("recive_queue");
//        Binding b = BindingBuilder.bind(q).to(directExchange).with("recive_key");
//
//        TopicExchange topic = new TopicExchange("topic_exchange");
//        Binding b1 = BindingBuilder.bind(q).to(topic).with("recive_key");
//
//
//        if (cccc==null) {
//
//            // 反射  每次生成新的
//            Class c = Class.forName("com.senyint.squeue.consumer.Receive");
//            Object o = c.newInstance();
//            BeanDefinitionBuilder beanDefinitionBuilder =
//                    BeanDefinitionBuilder.rootBeanDefinition(SimpleMessageListenerContainer.class);
//
//            /**
//             * 设置属性
//             */
//
//            // 在spring上下文中获得
//            Object messageListener = applicationContext.getBean("receive");
//            Object messageListener1 = applicationContext.getBean("receive");
//
//            if (!(messageListener instanceof MessageListener) && !(messageListener instanceof ChannelAwareMessageListener)) {
//                throw new IllegalArgumentException("Message listener needs to be of type ["
//                        + MessageListener.class.getName() + "] or ["
//                        + ChannelAwareMessageListener.class.getName() + "]");
//            }
//
//            beanDefinitionBuilder.addPropertyValue("connectionFactory", connectionFactory);
//            beanDefinitionBuilder.addPropertyValue("queueNames", "recive_queue");
//            beanDefinitionBuilder.addPropertyValue("messageListener", messageListener);
//            beanDefinitionBuilder.addPropertyValue("acknowledgeMode", AcknowledgeMode.MANUAL);
//
//            /**
//             * 注册到spring容器中
//             */
//            beanFactory.registerBeanDefinition("userService", beanDefinitionBuilder.getBeanDefinition());
//
//
//        }
//        return null;
//    }

}


//~ Formatted by Jindent --- http://www.jindent.com
