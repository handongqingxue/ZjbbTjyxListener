package com.zjbbTjyxListner.util;

import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;

public class APIUtil {

	public static final String SERVICE_URL="http://localhost:8080/ZjbbTjyx/opc/";

	//https://www.cnblogs.com/aeolian/p/7746158.html
	//https://www.cnblogs.com/bobc/p/8809761.html
	public static JSONObject doHttp(String method, Map<String, Object> params) throws IOException {
		// 构建请求参数  
        StringBuffer paramsSB = new StringBuffer();
		if (params != null) {  
            for (Entry<String, Object> e : params.entrySet()) {
            	paramsSB.append(e.getKey());  
            	paramsSB.append("=");  
            	paramsSB.append(e.getValue());  
            	paramsSB.append("&");  
            }  
            paramsSB.substring(0, paramsSB.length() - 1);  
        }  
		
		StringBuffer sbf = new StringBuffer(); 
		String strRead = null; 
		URL url = new URL(SERVICE_URL+method);
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("POST");//请求post方式
		connection.setDoInput(true); 
		connection.setDoOutput(true); 
		//header内的的参数在这里set    
		//connection.setRequestProperty("key", "value");
		connection.setRequestProperty("Content-Type", "application/json");
		connection.connect(); 
		
		OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(),"UTF-8"); 
		//OutputStream writer = connection.getOutputStream(); 
		writer.write(paramsSB.toString());
		writer.flush();
		InputStream is = connection.getInputStream(); 
		BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		while ((strRead = reader.readLine()) != null) {
			sbf.append(strRead); 
			sbf.append("\r\n"); 
		}
		reader.close();
		
		connection.disconnect();
		String result = sbf.toString();
		System.out.println("result==="+result);
		JSONObject resultJO = new JSONObject(result);
		return resultJO;
	}
	
	/**
	 * 初始化opc服务器的触发器变量到java端,为之后的同步变量做好准备
	 * @return
	 */
	public static JSONObject initJOpcTV() {
		// TODO Auto-generated method stub
		System.out.println("ppppppppp");
		JSONObject resultJO = null;
		try {
	        resultJO = doHttp("initJOpcTV",null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return resultJO;
		}
	}
	
	/**
	 * 初始化opc服务器的过程变量到java端,为之后的同步变量做好准备
	 * @return
	 */
	public static JSONObject initJOpcPV() {
		// TODO Auto-generated method stub
		JSONObject resultJO = null;
		try {
	        resultJO = doHttp("initJOpcPV",null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return resultJO;
		}
	}
	
	/**
	 * 同步触发器变量
	 * @return
	 */
	public static JSONObject syncTriggerVar() {
		// TODO Auto-generated method stub
		JSONObject resultJO = null;
		try {
	        resultJO = doHttp("syncTriggerVar",null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return resultJO;
		}
	}

	/**
	 * 巡回触发器变量状态
	 * @return
	 */
	public static JSONObject keepWatchOnTriggerVar() {
		// TODO Auto-generated method stub
		JSONObject resultJO = null;
		try {
	        resultJO = doHttp("keepWatchOnTriggerVar",null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return resultJO;
		}
	}

}
