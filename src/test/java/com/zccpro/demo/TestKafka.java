package com.zccpro.demo;

import org.junit.Test;

import com.zccpro.demo.consume.KafkaConsume;
import com.zccpro.demo.produce.KafkaProduce;

public class TestKafka {

	
	@org.junit.Test
	public void testproduce(){
		KafkaProduce kafkaProduce = new KafkaProduce();
		kafkaProduce.sendMsg("testzcc001","001key".getBytes(), "001value1233".getBytes());
	}
	
	@org.junit.Test
	public void testconsume(){
//		kafkaProduce.sendMsg("testzcc001","001key".getBytes(), "001value".getBytes());
		KafkaConsume kafkaConsume = new KafkaConsume();
		try {
			kafkaConsume.getMsg();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
