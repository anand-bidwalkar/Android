package com.example.reciverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SMSReciever extends BroadcastReceiver
{

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		
		String action=intent.getAction();
		Toast.makeText(context, " new msg.."+action, 5).show();
		
		Bundle bn=intent.getExtras();
		Object[] objArray= (Object[]) bn.get("pdus");// msg are stored using key pdus
		
			byte[] bar=(byte[]) objArray[0];
			
			SmsMessage sms=SmsMessage.createFromPdu(bar);
			
			String address=sms.getOriginatingAddress();
			String body=sms.getMessageBody();
			Toast.makeText(context, address+":"+body, 5).show();
			
			
	}

	

}
