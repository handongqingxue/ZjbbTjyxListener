package com.zjbbTjyxListner.task;

import org.json.JSONObject;

import com.zjbbTjyxListner.util.APIUtil;

/**
 * 这个类是用来监听从opc端服务器上同步变量到数据库的进程
 * @author Administrator
 *
 */
public class SyncTriggerTask extends Thread {

	/**
	 * 是否运行
	 */
	private boolean active;
	private boolean checked;
	private boolean allowChecked;

	public boolean isAllowChecked() {
		return allowChecked;
	}

	public void setAllowChecked(boolean allowChecked) {
		this.allowChecked = allowChecked;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("我都不惜说你了.........");
			JSONObject resultJO = APIUtil.initJOpcTV();
			String status = resultJO.get("status").toString();
			System.out.println("status==="+status);
			if("ok".equals(status))
				allowChecked=true;
			while (true) {
				if(!active)//不运行了，则跳出巡回检测
					break;
				checked=false;
				Thread.sleep(3000);
				APIUtil.syncTriggerVar();
				System.out.println("同步触发器变量........");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
