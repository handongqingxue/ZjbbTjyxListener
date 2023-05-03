package com.zjbbTjyxListner.task;

import com.zjbbTjyxListner.util.*;

public class KeepWatchTask extends Thread {
	
	/**
	 * 是否运行
	 */
	private boolean active;
	private boolean checked;

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
			while (true) {
				if(!active)//不运行了，则跳出巡回检测
					break;
				checked=false;
				Thread.sleep(3000);
				APIUtil.syncTriggerVar();
				APIUtil.keepWatchOnTriggerVar();
				System.out.println("巡回变量状态........");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
