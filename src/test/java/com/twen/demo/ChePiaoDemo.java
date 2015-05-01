package com.twen.demo;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import com.twen.data.ChePiaoData;
import com.twen.data.Result;

public class ChePiaoDemo
{

    public static void main(String[] args)
    {
        PostMethod postMethod = null;
        try{
            postMethod = new PostMethod("http://www.chepiao100.com/api/yupiao");
            postMethod.addRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
            //添加参数
            postMethod.addParameter("userid", "1012213470@qq.com");
            postMethod.addParameter("seckey", "176fb76bd5540d733f1a960cafe21618");
            postMethod.addParameter("date", "2014-10-18");
            postMethod.addParameter("startStation", "昆山南");
            postMethod.addParameter("arriveStation", "温州");
            HttpClient httpClient = new HttpClient();
            int resultCode = httpClient.executeMethod(postMethod);
            if(resultCode == 200){
                String resultStr = new String(postMethod.getResponseBody());
                resultStr = resultStr.replaceAll("-", "_");
                JSONObject obj = JSONObject.fromObject(resultStr);
                Map<String, Class> classMap = new HashMap<String, Class>(); 
                classMap.put("data", ChePiaoData.class);
                Result resultObj = (Result)JSONObject.toBean(obj,Result.class, classMap);
                for(ChePiaoData data : resultObj.getData()){
                    System.out.println("车次:" + data.getTrainCode());
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
