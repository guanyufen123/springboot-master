package com.example.demo.activemq.demo;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 路径：com.activemq.demo
 * 类名：JMSListenerConsumer
 * 功能：消息消费者
 * 备注：使用Listener监听方式
 * 创建人：typ
 * 创建时间：2018/8/14 22:07
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
public class JMSListenerConsumer {

    //默认的连接用户名
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    //默认的连接密码
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    //默认的连接地址
    private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;

    public static void main(String[] args) {
        // 连接工厂
        ConnectionFactory connectionFactory = null;
        // 连接
        Connection connection = null;
        // 会话，接受或者发送消息的线程
        Session session = null;
        // 消息的目的地
        Destination destination = null;
        // 消息的消费者
        MessageConsumer messageConsumer = null;

        //实例化连接工厂
        connectionFactory = new ActiveMQConnectionFactory(JMSListenerConsumer.USERNAME,JMSListenerConsumer.PASSWORD,JMSListenerConsumer.BROKEURL);

        try {
            // 通过连接工厂获取连接
            connection = connectionFactory.createConnection();
            // 启动连接
            connection.start();
            // 创建Session
            session = connection.createSession(Boolean.FALSE,Session.AUTO_ACKNOWLEDGE);
            // 创建连接的消息队列
            destination = session.createQueue("FirstQueue");
            // 创建消息消费者
            messageConsumer = session.createConsumer(destination);
            // 注册消息监听
            messageConsumer.setMessageListener(new Listener());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
