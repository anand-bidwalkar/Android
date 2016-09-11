package com.example.alarmservicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service{
@Override
public int onStartCommand(Intent intent, int flags, int startId) {
	// TODO Auto-generated method stub
	Toast.makeText(this, "service started:"+startId, 3).show();
	return super.onStartCommand(intent, flags, startId);
}
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

}
