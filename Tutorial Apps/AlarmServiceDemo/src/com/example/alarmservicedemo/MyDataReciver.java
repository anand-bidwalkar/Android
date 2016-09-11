package com.example.alarmservicedemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyDataReciver extends BroadcastReceiver 
{

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String d=intent.getStringExtra("mydata");
		Toast.makeText(context, d, 3).show();
		
	}

}
