package com.example.notificationdemo;

import android.app.Activity;
import android.app.NotificationManager;
import android.os.Bundle;

public class NextActvity extends Activity 
{
 @Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.next);
	//get the id of notice through which this actvity is launched
	int id=getIntent().getIntExtra("id",0);
	//clear the notice;
	NotificationManager nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
	nm.cancel(id);
	nm.cancelAll();
}
}
