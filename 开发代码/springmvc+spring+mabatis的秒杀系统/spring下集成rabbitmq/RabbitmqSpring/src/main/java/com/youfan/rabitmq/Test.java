package com.youfan.rabitmq;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		 ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		 Produceservice messageProducer = (Produceservice) context.getBean("produceservice"); 
		 Map<String, Object> map = new HashMap<String, Object>();
	        map.put("data", "hello rabbitmq");
	        // ע�⣺�ڶ��������� Queue �� �������󶨵�·��
	        messageProducer.sendQueue("test_mq_exchange", "test_mq_patt", map);
	}
}
