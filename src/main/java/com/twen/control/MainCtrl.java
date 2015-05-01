package com.twen.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import com.twen.data.ChePiaoData;
import com.twen.data.JiPiaoData;
import com.twen.data.Result;
import com.twen.data.Result2;



public class MainCtrl extends HttpServlet {

	public MainCtrl() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	this.doPost(request, response);
	}

		public void go(String url,HttpServletRequest request, HttpServletResponse response)
		{
		try {
			request.getRequestDispatcher(url).forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		
		public void gor(String url,HttpServletRequest request, HttpServletResponse response)
		{
			try {
				response.sendRedirect(url);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        response.setContentType("text/html");
		String ac = request.getParameter("ac");
		if(ac==null)ac="";
		
		if(ac.equals("querychepiao"))
		{
			String startStation = request.getParameter("startStation");
			String arriveStation = request.getParameter("arriveStation");
			String date = request.getParameter("date");
			//System.out.println(date);
			
	        PostMethod postMethod = null;
	        try{
	            postMethod = new PostMethod("http://www.chepiao100.com/api/yupiao");
	            //postMethod.addRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
	            //添加参数
	            postMethod.addParameter("userid", "1012213470@qq.com");
	            postMethod.addParameter("seckey", "176fb76bd5540d733f1a960cafe21618");
	            postMethod.addParameter("date", date);
	            postMethod.addParameter("startStation", startStation);
	            postMethod.addParameter("arriveStation", arriveStation);
	            //System.out.println(postMethod);
	            HttpClient httpClient = new HttpClient();
	            int resultCode = httpClient.executeMethod(postMethod);
	            if(resultCode == 200){
	                String resultStr = new String(postMethod.getResponseBody());
	                resultStr = resultStr.replaceAll("-", "_");
	                JSONObject obj = JSONObject.fromObject(resultStr);
	                Map<String, Class> classMap = new HashMap<String, Class>();
	                classMap.put("data", ChePiaoData.class);
	                Result resultObj = (Result)JSONObject.toBean(obj,Result.class, classMap);
	                //System.out.println(resultObj.getData());
/*	                for(ChePiaoData data : resultObj.getData()){
	                    System.out.println("车次:" + data.getTrainCode());
	                }*/
	                request.setAttribute("chepiaolist", resultObj.getData());
	            }
	        }catch(Exception e){
	            e.printStackTrace();
	        }finally{
	            if(postMethod != null){
	                postMethod.releaseConnection();
	            }
	            go("/show.jsp", request, response);
	        }
			
		}
		
		if(ac.equals("queryjipiao"))
		{
			String departureAirport = request.getParameter("departureAirport");
			String arrivalAirport = request.getParameter("arrivalAirport");
			String date = request.getParameter("date");
			//System.out.println(date);
			
			 PostMethod postMethod = null;
			    try{
			        postMethod = new PostMethod("http://www.chepiao100.com/api/jipiao");
			       // postMethod.addRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
			        //添加参数
			        postMethod.addParameter("userid", "1012213470@qq.com");
			        postMethod.addParameter("seckey", "176fb76bd5540d733f1a960cafe21618");
			        postMethod.addParameter("date", date);
			        postMethod.addParameter("departureAirport", departureAirport);
			        postMethod.addParameter("arrivalAirport", arrivalAirport);
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
		/*	            for(JiPiaoData data2 : resultObj.getData()){
			                System.out.println("航空公司:" + data2.getCompanyNo());
			            }*/
			            request.setAttribute("jipiaolist", resultObj.getData());
			        }
			    }catch(Exception e){
			        e.printStackTrace();
			    }finally{
			        if(postMethod != null){
			            postMethod.releaseConnection();
			        }
			        go("/MyJsp.jsp", request, response);
			 }
		}
		
	}
	public void init() throws ServletException {
		// Put your code here
	}
	
	

}
