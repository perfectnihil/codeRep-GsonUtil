package com.mc.gsonutil;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GsonUtil {
	
	
	public static Gson gson = new Gson();
	
	/**
	 * 从jsonString 中获取对象
	 * @param t
	 * @param jsonString
	 * @return
	 */
	public synchronized static  <T>  T getBeanFromString(Class<T> t,String jsonString){
		if(gson==null) {gson = new Gson();}
		T result_obj = gson.fromJson(jsonString, t);
		return result_obj;
	}
	/**
	 * 从jsonString 中获取数组
	 * @param t
	 * @param jsonString
	 * @return
	 */
	public synchronized static <T> List<T> getBeanListFromString(Class<T> t,String jsonString){
		if(gson==null) {gson = new Gson();}
		List<T> mResultList = null;
		mResultList =  gson.fromJson(jsonString,new TypeToken<ArrayList<T>>(){}.getType());
		return mResultList;
	}
	
}
