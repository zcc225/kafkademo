package com.zccpro.demo;

import static org.junit.Assert.*;

import com.zccpro.demo.model.User;
import com.zccpro.demo.util.JsonUtils;

import kafka.utils.Json;

public class TestJson {

	
	@org.junit.Test
	public void testObjToJson() {
		User user = new User();
		user.setAge("19");
		user.setPassword("passw");
		user.setUsername("username");
		String objToJson = JsonUtils.ObjToJson(user);
		System.out.println(objToJson);
	}
	
	@org.junit.Test
	public void testJsonToObj() {
		User user = new User();
		user.setAge("19");
		user.setPassword("passw");
		user.setUsername("username");
		String objToJson = JsonUtils.ObjToJson(user);
		User user1 = (User)JsonUtils.JsonToObj(objToJson, User.class);
		System.out.println(user.toString());
	}

}
