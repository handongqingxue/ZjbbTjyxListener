package com.zjbbTjyxListner.task;

import com.zjbbTjyxListner.util.*;

public class KeepWatchTask extends Thread {
	
	/**
	 * �Ƿ�����
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
				if(!active)//�������ˣ�������Ѳ�ؼ��
					break;
				checked=false;
				Thread.sleep(3000);
				APIUtil.keepWatchOnTriggerVar();
				System.out.println("Ѳ�ر���״̬........");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
