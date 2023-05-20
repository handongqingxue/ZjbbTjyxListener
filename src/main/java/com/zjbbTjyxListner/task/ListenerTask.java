package com.zjbbTjyxListner.task;

import com.zjbbTjyxListner.util.*;
import org.apache.commons.lang.StringUtils;


import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

public class ListenerTask extends Thread implements ActionListener {
	
	private SyncTriggerTask syncTriggerTask;
	private KeepWatchTask keepWatchTask;
//	private SendMesBRTask sendMesBRTask;
	private JTextField ipAddressPortJTF,dbConnectJTF;
	private JButton saveJb,startJb,stopJb;
	private JLabel startLightJLabel,stopLightJLabel;
	private int unCheckCountSTT;
	private int unCheckCountKWT;
	private int unCheckCountSMBRT;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			changeLightJLabelStyle(true);
			
			//syncTriggerTask=StartTask.syncTriggerTask;
			//System.out.println("syncTriggerTask==="+syncTriggerTask);
			
			keepWatchTask=StartTask.keepWatchTask;
			System.out.println("keepWatchTask==="+keepWatchTask);
			
			//sendMesBRTask=StartTask.sendMesBRTask;
			//System.out.println("sendMesBRTask==="+sendMesBRTask);
			
			while (true) {
				/*
				boolean isCheckedSTT = syncTriggerTask.isChecked();//���ͬ�������������ļ���ʶ
				System.out.println("isCheckedSTT1==="+isCheckedSTT);
				if(!isCheckedSTT) {//��û�б�������˵���м������һֱ�����У��޸ļ���ʶΪ�Ѽ��
					syncTriggerTask.setChecked(true);
					System.out.println("isCheckedSTT2==="+isCheckedSTT);
					unCheckCountSTT=0;//δ����������
				}
				else {//���м���ļ���ʶ���Ѽ�⣬˵��ֹͣ�����ˣ��͵��ۼ�δ�������������Ƿ����ֹͣ����
					unCheckCountSTT++;
				}
				System.out.println("unCheckCountSTT==="+unCheckCountSTT);
				
				if(unCheckCountSTT>3) {//δ�������ۼ��������ϣ�˵���м�����ֹͣ�����ˣ���Ҫ�ٴ������м��
					System.out.println("����.....");
					stopDKJavaSTRunner();//��ֹͣ�м������
					startDKJavaSTRunner();//�ٿ����м�����̣�����ռ���ڴ���Դ
					unCheckCountSTT=0;//δ����������
					System.out.println("isCheckedSTT2==="+isCheckedSTT);
				}
				*/
				
				
				boolean isCheckedKWT = keepWatchTask.isChecked();//���Ѳ����̵ļ���ʶ
				System.out.println("isCheckedKWT1==="+isCheckedKWT);
				if(!isCheckedKWT) {//��û�б�������˵���м������һֱ�����У��޸ļ���ʶΪ�Ѽ��
					keepWatchTask.setChecked(true);
					System.out.println("isCheckedKWT2==="+isCheckedKWT);
					unCheckCountKWT=0;//δ����������
				}
				else {//���м���ļ���ʶ���Ѽ�⣬˵��ֹͣ�����ˣ��͵��ۼ�δ�������������Ƿ����ֹͣ����
					unCheckCountKWT++;
				}
				System.out.println("unCheckCountKWT==="+unCheckCountKWT);
				
				if(unCheckCountKWT>3) {//δ�������ۼ��������ϣ�˵���м�����ֹͣ�����ˣ���Ҫ�ٴ������м��
					System.out.println("����.....");
					stopDKJavaRunner();//��ֹͣ�м������
					startDKJavaRunner();//�ٿ����м�����̣�����ռ���ڴ���Դ
					unCheckCountKWT=0;//δ����������
					System.out.println("isCheckedKWT2==="+isCheckedKWT);
				}
				

				/*
				boolean isCheckedSMBRT = sendMesBRTask.isChecked();
				System.out.println("isCheckedSMBRT1==="+isCheckedSMBRT);
				if(!isCheckedSMBRT) {//��û�б�������˵���м������һֱ�����У��޸ļ���ʶΪ�Ѽ��
					sendMesBRTask.setChecked(true);
					System.out.println("isCheckedSMBRT2==="+isCheckedSMBRT);
					unCheckCountSMBRT=0;//δ����������
				}
				else {//���м���ļ���ʶ���Ѽ�⣬˵��ֹͣ�����ˣ��͵��ۼ�δ�������������Ƿ����ֹͣ����
					unCheckCountSMBRT++;
				}
				System.out.println("unCheckCountSMBRT==="+unCheckCountSMBRT);
				
				if(unCheckCountSMBRT>3) {//δ�������ۼ��������ϣ�˵���м�����ֹͣ�����ˣ���Ҫ�ٴ������м��
					System.out.println("����.....");
					stopDKJavaBRRunner();//��ֹͣ�м������
					startDKJavaBRRunner();//�ٿ����м�����̣�����ռ���ڴ���Դ
					unCheckCountSMBRT=0;//δ����������
					System.out.println("isCheckedSMBRT2==="+isCheckedSMBRT);
				}
				*/
				
				
				
				Thread.sleep(3000);//ÿ��������һ���м��
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ����java�м������
	 */
	private void startDKJavaRunner() {
		keepWatchTask=new KeepWatchTask();
		keepWatchTask.setActive(true);
		keepWatchTask.setChecked(true);
		keepWatchTask.start();
		System.out.println("isActive==="+keepWatchTask.isActive());
		System.out.println("bbbbbbbbbbbbbb");
	}
	
	/**
	 * ֹͣjava�м������
	 */
	private void stopDKJavaRunner() {
		keepWatchTask.stop();
		keepWatchTask.setActive(false);
		System.out.println("ddddddddddddddddd");
	}
	
	private void startDKJavaSTRunner() {
		syncTriggerTask=new SyncTriggerTask();
		syncTriggerTask.setActive(true);
		syncTriggerTask.setChecked(true);
		syncTriggerTask.start();
		System.out.println("isActive==="+syncTriggerTask.isActive());
	}
	
	private void stopDKJavaSTRunner() {
		syncTriggerTask.stop();
		syncTriggerTask.setActive(false);
	}
	
//	private void startDKJavaBRRunner() {
//		sendMesBRTask=new SendMesBRTask();
//		sendMesBRTask.setActive(true);
//		sendMesBRTask.setChecked(true);
//		sendMesBRTask.start();
//		System.out.println("isActive==="+sendMesBRTask.isActive());
//		System.out.println("bbbbbbbbbbbbbb");
//	}
//
//	private void stopDKJavaBRRunner() {
//		sendMesBRTask.stop();
//		sendMesBRTask.setActive(false);
//		System.out.println("ddddddddddddddddd");
//	}
//
	/**
	 * ��ʼ��������
	 */
	public void initMainJFrame() {
		//https://mbd.baidu.com/ug_share/mbox/4a83aa9e65/share?product=smartapp&tk=06559b750ffdd64b94081e8e3c1fc3d6&share_url=https%3A%2F%2Fsa93g4.smartapps.baidu.com%2Fpages%2Fsquestion%2Fsquestion%3Fqid%3D562121822%26rid%3D1410602677%26_swebfr%3D1%26_swebFromHost%3Dbaiduboxapp&domain=mbd.baidu.com
		System.out.println("11111keepWatchTask==="+keepWatchTask);
		JFrame jf=new JFrame(Constant.MAIN_JFRAME_TITLE);
		jf.setBounds(Constant.MAIN_JFRAME_X, Constant.MAIN_JFRAME_Y, Constant.MAIN_JFRAME_WIDTH, Constant.MAIN_JFRAME_HEIGHT);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*
		JPanel jp=new JPanel(null);
		LineBorder lb = new LineBorder(Color.BLACK, 1, false);
		jp.setBorder(BorderFactory.createTitledBorder(lb, "��ӭ����", TitledBorder.LEFT, TitledBorder.TOP));
		jp.setBackground(new Color(240, 240, 240));
		jf.add(jp);
		*/
		jf.add(initMainJPanel());
		
		//jf.show();
		jf.setVisible(true);//һ�ж�������֮�����ʾ������
	}
	
	/**
	 * ��ʼ�������
	 * @return
	 */
	private JPanel initMainJPanel() {
		JPanel jp=new JPanel(null);
		jp.setSize(Constant.MAIN_JPANEL_WIDTH, Constant.MAIN_JPANEL_HEIGHT);
		jp.add(initConnectJPanel());
		jp.add(initServerJPanel());
		jp.add(initWatchStateMsgJLabel());
		return jp;
	}
	
	/**
	 * ��ʼ���������������
	 * @return
	 */
	private JPanel initConnectJPanel() {
		JPanel jp=new JPanel(null);
		LineBorder lb=new LineBorder(new Color(Constant.CONNECT_JPANEL_BORDER_COLOR_R,Constant.CONNECT_JPANEL_BORDER_COLOR_G,Constant.CONNECT_JPANEL_BORDER_COLOR_B), 1, false);
		jp.setBorder(BorderFactory.createTitledBorder(lb, Constant.CONNECT_JPANEL_BORDER_TITLE, TitledBorder.LEFT, TitledBorder.TOP));
		jp.setBounds(Constant.CONNECT_JPANEL_X, Constant.CONNECT_JPANEL_Y, Constant.CONNECT_JPANEL_WIDTH, Constant.CONNECT_JPANEL_HEIGHT);
		
		jp.add(initIPAddressPortJLabel());
		jp.add(initIPAddressPortJTextField());
		
		jp.add(initDBConnectJLabel());
		jp.add(initDBConnectJTextField());
		
		jp.add(initSaveJButton());
		
		return jp;
	}
	
	/**
	 * ��ʼ��ip��ַ�Ͷ˿ںű�ǩ
	 * @return
	 */
	private JLabel initIPAddressPortJLabel() {
		JLabel jl=new JLabel();
		jl.setText(Constant.IP_ADDRESS_PORT_JLABEL_TEXT);
		jl.setBounds(Constant.IP_ADDRESS_PORT_JLABEL_X, Constant.IP_ADDRESS_PORT_JLABEL_Y, Constant.IP_ADDRESS_PORT_JLABEL_WIDTH, Constant.IP_ADDRESS_PORT_JLABEL_HEIGHT);
		//jl.setBackground(Color.RED);
		//jl.setOpaque(true);
		
		return jl;
	}
	
	/**
	 * ��ʼ��ip��ַ�Ͷ˿ں��ı���
	 * @return
	 */
	private JTextField initIPAddressPortJTextField() {
		//JTextField��ʾ���˽������:https://www.zzzyk.com/show/a99aeecdee6fb83a.htm
		ipAddressPortJTF=new JTextField();
		ipAddressPortJTF.setBounds(Constant.IP_ADDRESS_PORT_JTEXTFIELD_X, Constant.IP_ADDRESS_PORT_JTEXTFIELD_Y, Constant.IP_ADDRESS_PORT_JTEXTFIELD_WIDTH, Constant.IP_ADDRESS_PORT_JTEXTFIELD_HEIGHT);
		
		return ipAddressPortJTF;
	}
	
	/**
	 * ��ʼ�����ݿ����ӱ�ǩ
	 * @return
	 */
	private JLabel initDBConnectJLabel() {
		JLabel jl=new JLabel();
		jl.setText(Constant.DB_CONNECT_JLABEL_TEXT);
		jl.setBounds(Constant.DB_CONNECT_JLABEL_X, Constant.DB_CONNECT_JLABEL_Y, Constant.DB_CONNECT_JLABEL_WIDTH, Constant.DB_CONNECT_JLABEL_HEIGHT);
		//jl.setBackground(Color.RED);
		//jl.setOpaque(true);
		
		return jl;
	}
	
	/**
	 * ��ʼ�����ݿ������ı���
	 * @return
	 */
	private JTextField initDBConnectJTextField() {
		dbConnectJTF=new JTextField();
		dbConnectJTF.setBounds(Constant.DB_CONNECT_JTEXTFIELD_X, Constant.DB_CONNECT_JTEXTFIELD_Y, Constant.DB_CONNECT_JTEXTFIELD_WIDTH, Constant.DB_CONNECT_JTEXTFIELD_HEIGHT);
		
		return dbConnectJTF;
	}
	
	/**
	 * ��ʼ�����水ť
	 * @return
	 */
	private JButton initSaveJButton() {
		saveJb=new JButton(Constant.SAVE_JBUTTON_TEXT);
		saveJb.setBorder(BorderFactory.createLineBorder(new Color(Constant.SAVE_JBUTTON_BORDER_COLOR_R, Constant.SAVE_JBUTTON_BORDER_COLOR_G, Constant.SAVE_JBUTTON_BORDER_COLOR_B)));
		saveJb.setBackground(new Color(Constant.SAVE_JBUTTON_BG_COLOR_R, Constant.SAVE_JBUTTON_BG_COLOR_R, Constant.SAVE_JBUTTON_BG_COLOR_R));
		saveJb.setBounds(Constant.SAVE_JBUTTON_X, Constant.SAVE_JBUTTON_Y, Constant.SAVE_JBUTTON_WIDTH, Constant.SAVE_JBUTTON_HEIGHT);
		saveJb.addActionListener(this);
		return saveJb;
	}
	
	/**
	 * ��ʼ���������������
	 * @return
	 */
	private JPanel initServerJPanel() {
		JPanel jp=new JPanel(null);
		LineBorder lb=new LineBorder(new Color(Constant.SERVER_JPANEL_BORDER_COLOR_R,Constant.SERVER_JPANEL_BORDER_COLOR_G,Constant.SERVER_JPANEL_BORDER_COLOR_B), 1, false);
		jp.setBorder(BorderFactory.createTitledBorder(lb, Constant.SERVER_JPANEL_BORDER_TITLE, TitledBorder.LEFT, TitledBorder.TOP));
		jp.setBounds(Constant.SERVER_JPANEL_X, Constant.SERVER_JPANEL_Y, Constant.SERVER_JPANEL_WIDTH, Constant.SERVER_JPANEL_HEIGHT);
		//jp.setBackground(Color.RED);
		jp.add(initLightJPanel());
		jp.add(initStartJButton());
		jp.add(initStopJButton());
		
		return jp;
	}
	
	/**
	 * ��ʼ��ָʾ�����
	 * @return
	 */
	private JPanel initLightJPanel() {
		JPanel jp=new JPanel(null);
		jp.setBorder(BorderFactory.createLineBorder(new Color(Constant.LIGHT_JPANEL_BORDER_COLOR_R, Constant.LIGHT_JPANEL_BORDER_COLOR_G, Constant.LIGHT_JPANEL_BORDER_COLOR_B)));
		//jp.setBackground(Color.RED);
		jp.setBounds(Constant.LIGHT_JPANEL_X, Constant.LIGHT_JPANEL_Y, Constant.LIGHT_JPANEL_WIDTH, Constant.LIGHT_JPANEL_HEIGHT);
		
		jp.add(initStartLightJLabel());
		jp.add(initStopLightJLabel());
		
		return jp;
	}
	
	/**
	 * ��ʼ����ʼָʾ�Ʊ�ǩ
	 * @return
	 */
	private JLabel initStartLightJLabel() {
		startLightJLabel=new JLabel();
		startLightJLabel.setBounds(Constant.START_LIGHT_JLABEL_X, Constant.START_LIGHT_JLABEL_Y, Constant.START_LIGHT_JLABEL_WIDTH, Constant.START_LIGHT_JLABEL_HEIGHT);
		startLightJLabel.setOpaque(true);

		return startLightJLabel;
	}
	
	/**
	 * ��ʼ������ָʾ�Ʊ�ǩ
	 * @return
	 */
	private JLabel initStopLightJLabel() {
		stopLightJLabel=new JLabel();
		stopLightJLabel.setBounds(Constant.STOP_LIGHT_JLABEL_X, Constant.STOP_LIGHT_JLABEL_Y, Constant.STOP_LIGHT_JLABEL_WIDTH, Constant.STOP_LIGHT_JLABEL_HEIGHT);
		stopLightJLabel.setOpaque(true);

		return stopLightJLabel;
	}
	
	/**
	 * �ı�ָʾ�Ʊ�ǩ��ʽ
	 * @param start
	 */
	private void changeLightJLabelStyle(boolean start) {
		if(start) {
			startLightJLabel.setBackground(new Color(Constant.START_LIGHT_JLABEL_START_BG_COLOR_R, Constant.START_LIGHT_JLABEL_START_BG_COLOR_G, Constant.START_LIGHT_JLABEL_START_BG_COLOR_B));
			stopLightJLabel.setBackground(new Color(Constant.STOP_LIGHT_JLABEL_START_BG_COLOR_R, Constant.STOP_LIGHT_JLABEL_START_BG_COLOR_G, Constant.STOP_LIGHT_JLABEL_START_BG_COLOR_B));
			
			startJb.setEnabled(false);
			stopJb.setEnabled(true);
		}
		else {
			startLightJLabel.setBackground(Color.RED);
			stopLightJLabel.setBackground(Color.GREEN);
			
			startJb.setEnabled(true);
			stopJb.setEnabled(false);
		}
	}
	
	/**
	 * ��ʼ��������ť
	 * @return
	 */
	private JButton initStartJButton() {
		startJb=new JButton(Constant.START_JBUTTON_TEXT);
		startJb.setBorder(BorderFactory.createLineBorder(new Color(Constant.START_JBUTTON_BORDER_COLOR_R, Constant.START_JBUTTON_BORDER_COLOR_G, Constant.START_JBUTTON_BORDER_COLOR_B)));
		startJb.setBackground(new Color(Constant.START_JBUTTON_BG_COLOR_R, Constant.START_JBUTTON_BG_COLOR_G, Constant.START_JBUTTON_BG_COLOR_B));
		startJb.setBounds(Constant.START_JBUTTON_X, Constant.START_JBUTTON_Y, Constant.START_JBUTTON_WIDTH, Constant.START_JBUTTON_HEIGHT);
		startJb.addActionListener(this);
		return startJb;
	}
	
	/**
	 * ��ʼ��ֹͣ��ť
	 * @return
	 */
	private JButton initStopJButton() {
		stopJb=new JButton(Constant.STOP_JBUTTON_TEXT);
		stopJb.setBorder(BorderFactory.createLineBorder(new Color(Constant.STOP_JBUTTON_BORDER_COLOR_R, Constant.STOP_JBUTTON_BORDER_COLOR_G, Constant.STOP_JBUTTON_BORDER_COLOR_B)));
		stopJb.setBackground(new Color(Constant.STOP_JBUTTON_BG_COLOR_R, Constant.STOP_JBUTTON_BG_COLOR_G, Constant.STOP_JBUTTON_BG_COLOR_B));
		stopJb.setBounds(Constant.STOP_JBUTTON_X, Constant.STOP_JBUTTON_Y, Constant.STOP_JBUTTON_WIDTH, Constant.STOP_JBUTTON_HEIGHT);
		stopJb.addActionListener(this);
		return stopJb;
	}
	
	/**
	 * ��ʼ��WATCH DOG״̬��Ϣ��ǩ
	 * @return
	 */
	private JLabel initWatchStateMsgJLabel() {
		JLabel jl=new JLabel();
		jl.setText("WATCH DOG����⹦�������� ������������");
		jl.setBounds(Constant.WATCH_STATE_MSG_JLABEL_X, Constant.WATCH_STATE_MSG_JLABEL_Y, Constant.WATCH_STATE_MSG_JLABEL_WIDTH, Constant.WATCH_STATE_MSG_JLABEL_HEIGHT);
		//jl.setBackground(Color.RED);
		//jl.setOpaque(true);
		
		loadDBConfig();
		
		return jl;
	}
	
	private void loadDBConfig() {
		try {
			File resourcesDir = new File(Constant.RESOURCES_DIR);
			String resourcesPath = resourcesDir.getCanonicalPath();
			String iniPath =resourcesPath+"/db.ini";
			Map<String, String> map = IniUtil.readKeys(iniPath);
			String ipAddressPort = map.get(Constant.IP_ADDRESS_PORT_KEY);
			String dbConnect = map.get(Constant.DB_CONNECT_KEY);
			System.out.println("���ݿ��ַ:"+ipAddressPort);
			System.out.println("���ݿ�����:"+dbConnect);
			ipAddressPortJTF.setText(ipAddressPort);
			dbConnectJTF.setText(dbConnect);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void editDBConfig() {
		try {
			File resourcesDir = new File(Constant.RESOURCES_DIR);
			String resourcesPath = resourcesDir.getCanonicalPath();
			String iniPath =resourcesPath+"/db.ini";
			
			String ipAddressPort = ipAddressPortJTF.getText();
			String dbConnect = dbConnectJTF.getText();
			
			LinkedHashMap<String,Object> map=new LinkedHashMap();
			map.put(Constant.IP_ADDRESS_PORT_KEY, ipAddressPort);
			map.put(Constant.DB_CONNECT_KEY, dbConnect);
			map.put(Constant.JDBC_URL_KEY, "jdbc:sqlserver://"+ipAddressPort+";DatabaseName="+dbConnect);
			IniUtil.writeKeys(iniPath, Constant.CONNECT_INFO_SECTION, map);
			
			JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton source = (JButton)e.getSource();
		if(source==saveJb) {
			if(checkIPAddressPort()) {
				if(checkDBConnect()) {
					editDBConfig();
				}
			}
		}
		if(source==startJb) {
			System.out.println("aaaaaaaaaaaaaa");
			//startDKJavaRunner();
			//startDKJavaBRRunner();
			changeLightJLabelStyle(true);
		}
		else if(source==stopJb) {
			System.out.println("bbbbbbbbbbbbb");
			//stopDKJavaRunner();
			//stopDKJavaBRRunner();
			changeLightJLabelStyle(false);
		}
	}
	
	private boolean checkIPAddressPort() {
		String ipAddressPort = ipAddressPortJTF.getText();
		if(StringUtils.isEmpty(ipAddressPort)) {
			JOptionPane.showMessageDialog(null, "������"+Constant.IP_ADDRESS_PORT_JLABEL_TEXT);
			return false;
		}
		else
			return true;
	}
	
	private boolean checkDBConnect() {
		String dbConnect = dbConnectJTF.getText();
		if(StringUtils.isEmpty(dbConnect)) {
			JOptionPane.showMessageDialog(null, "������"+Constant.DB_CONNECT_JLABEL_TEXT);
			return false;
		}
		else
			return true;
	}

}
