package com.zjbbTjyxListner.task;

import com.zjbbTjyxListner.util.APIUtil;

public class SyncTriggerTask extends Thread {

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
			APIUtil.initJOpcTV();
			while (true) {
				if(!active)//�������ˣ�������Ѳ�ؼ��
					break;
				checked=false;
				Thread.sleep(3000);
				APIUtil.syncTriggerVar();
				System.out.println("ͬ������������........");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
