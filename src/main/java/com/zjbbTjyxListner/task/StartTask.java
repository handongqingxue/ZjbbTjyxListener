package com.zjbbTjyxListner.task;

import com.zjbbTjyxListner.util.Constant;
import com.zjbbTjyxListner.util.IniUtil;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class StartTask {
	
	static KeepWatchTask keepWatchTask;
	static SyncTriggerTask syncTriggerTask;
//	static SendMesBRTask sendMesBRTask;
	static ListenerTask listenerTask;
	
	public static void main(String[] args) {
		//���exe:https://blog.csdn.net/qq_40298902/article/details/114489753
		syncTriggerTask=new SyncTriggerTask();
		syncTriggerTask.setActive(true);
		syncTriggerTask.start();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		keepWatchTask=new KeepWatchTask();
		keepWatchTask.setActive(true);
		keepWatchTask.start();
		
		//sendMesBRTask=new SendMesBRTask();
		//sendMesBRTask.setActive(true);
		//sendMesBRTask.start();
		
		listenerTask=new ListenerTask();
		listenerTask.initMainJFrame();
		listenerTask.start();
		//readIniFile();
	}

	public static void readIniFile(){
		//��ȡresources���ļ���·��
		File resourcesDir = new File(Constant.RESOURCES_DIR);
		String resourcesPath = null;
		try {
			resourcesPath = resourcesDir.getCanonicalPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//resource��������Ҫ��·�� eg: resource="D:\��Ŀ��\src\main\resources\files\****"
		String iniPath =resourcesPath+"/db.ini";
		try {
			Map<String, String> map = IniUtil.readKeys(iniPath);
			String ipAddressPort = map.get(Constant.IP_ADDRESS_PORT_KEY);
			String dbConnect = map.get(Constant.DB_CONNECT_KEY);
			System.out.println("���ݿ��ַ:"+ipAddressPort);
			System.out.println("���ݿ�����:"+dbConnect);
			
			LinkedHashMap<String,Object> map1=new LinkedHashMap();
			map1.put(Constant.DB_CONNECT_KEY, "BatchMesCom");
			IniUtil.writeKeys(iniPath, Constant.CONNECT_INFO_SECTION, map1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
