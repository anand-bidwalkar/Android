
package com.example.phonebusyapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;

public class MyService extends Service
{
	String num="";
	int phoneState=0;
	TelephonyManager tm;
	
  @Override
public void onCreate() {
	// TODO Auto-generated method stub
	super.onCreate();
	
	tm=(TelephonyManager) getSystemService(TELEPHONY_SERVICE);
	tm.listen(new MyPhoneSateListener(), PhoneStateListener.LISTEN_CALL_STATE);;
}

  class MyPhoneSateListener extends PhoneStateListener
  {
	  @Override
	public void onCallStateChanged(int state, String incomingNumber) {
		// TODO Auto-generated method stub
		super.onCallStateChanged(state, incomingNumber);
		phoneState=state;
		num=incomingNumber;
		if(phoneState==TelephonyManager.CALL_STATE_RINGING)
		{
			WaitThread thread=new WaitThread();
			thread.start();
		}
	}
  }
  
  class WaitThread extends Thread
  {
	  @Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		try {
			Thread.sleep(20000);
			if(phoneState==TelephonyManager.CALL_STATE_RINGING)
			{
				SmsManager mn=SmsManager.getDefault();
				mn.sendTextMessage(num, null, "busy, call u later.." ,null,null);
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
  }
@Override
public IBinder onBind(Intent intent) {
	// TODO Auto-generated method stub
	return null;
}
}
