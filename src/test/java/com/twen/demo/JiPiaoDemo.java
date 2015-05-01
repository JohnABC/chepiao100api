package com.twen.demo;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import com.twen.data.JiPiaoData;
import com.twen.data.Result2;

public class JiPiaoDemo {
	public static void main(String[] args) {
	 PostMethod postMethod = null;
	    try{
	        postMethod = new PostMethod("http://www.chepiao100.com/api/jipiao");
	        postMethod.addRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
	        //添加参数
	        postMethod.addParameter("userid", "joneyee22@qq.com");
	        postMethod.addParameter("seckey", "6786ccd9ebf41fb93f7530943ef4ce68");
	        postMethod.addParameter("date", "2014-05-3");
	        postMethod.addParameter("departureAirport", "上海");
	        postMethod.addParameter("arrivalAirport", "济南");
	        System.out.println(postMethod);
	        HttpClient httpClient = new HttpClient();
	        int resultCode = httpClient.executeMethod(postMethod);
	        System.out.println(resultCode);
	        if(resultCode == 200){
	            String resultStr = new String(postMethod.getResponseBody());
	           // resultStr = resultStr.replaceAll("-", "_");
	            JSONObject obj = JSONObject.fromObject(resultStr);
	            Map<String, Class> classMap = new HashMap<String, Class>(); 
	            classMap.put("data", JiPiaoData.class);
	            Result2 resultObj = (Result2)JSONObject.toBean(obj, Result2.class, classMap);
	            System.out.println(resultObj);
	            System.out.println(resultObj.getData());
	            for(JiPiaoData data2 : resultObj.getData()){
	                System.out.println("航空公司:" + data2.getCompanyNo());
	            }
	        }
	    }catch(Exception e){
	        e.printStackTrace();
	    }finally{
	        if(postMethod != null){
	            postMethod.releaseConnection();
	        }
	    }
	}

}
