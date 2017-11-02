package com.zccpro.demo;

import java.nio.charset.Charset;

import org.junit.Test;

import com.zccpro.demo.consume.KafkaConsume;
import com.zccpro.demo.produce.KafkaProduce;

import kafka.consumer.ConsumerIterator;

public class TestKafka {

	
	@org.junit.Test
	public void testproduce(){
		KafkaProduce kafkaProduce = new KafkaProduce();
		kafkaProduce.sendMsg("testzcc02","001key".getBytes(), "0000".getBytes());
	}
	
	@org.junit.Test
	public void testproducemsg(){
		KafkaProduce kafkaProduce = new KafkaProduce();
		kafkaProduce.sendMsg("testzcc02", "0000111");
	}
	
	@org.junit.Test
	public void testconsume(){
//		kafkaProduce.sendMsg("testzcc001","001key".getBytes(), "001value".getBytes());
		KafkaConsume kafkaConsume = new KafkaConsume("testzcc01");
		try {
			kafkaConsume.getMsg();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@org.junit.Test
	public void testconsumeiterator(){
//		kafkaProduce.sendMsg("testzcc001","001key".getBytes(), "001value".getBytes());
		ConsumerIterator<String, String> it = new KafkaConsume("testzcc02").getConsumerIterator();
		while(it.hasNext()){
			 String json = it.next().message();
//           User user = (User) JsonUtils.JsonToObj(json, User.class);
           System.out.println(json+"testzcc02处理le");
		}
	}
	
}
