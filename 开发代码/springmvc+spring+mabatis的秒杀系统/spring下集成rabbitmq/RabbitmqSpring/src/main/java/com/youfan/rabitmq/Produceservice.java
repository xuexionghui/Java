package com.youfan.rabitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Produceservice {
	 @Autowired
	    private AmqpTemplate amqpTemplate;
	    
	    public void sendQueue(String exchange_key, String queue_key, Object object) {
	        // convertAndSend ��Java����ת��Ϊ��Ϣ������ƥ��key�Ľ�������Exchange
	        amqpTemplate.convertAndSend(exchange_key, queue_key, object);
	    }
}

