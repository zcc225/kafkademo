package com.zccpro.demo.util;

import com.google.gson.Gson;

public class JsonUtils {

	private static Gson gson =  null;
	
	static {
		gson = new Gson();
	}
	
	@SuppressWarnings("unchecked")
	public static Object JsonToObj(String json,Class cla){
		return gson.fromJson(json, cla);
		
	}
	
	
	public static String ObjToJson(Object obj){
		return gson.toJson(obj);
	}
	
	
}
