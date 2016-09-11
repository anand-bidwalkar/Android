package com.example.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service
{
	
		@Override
		public void onCreate() {
			// TODO Auto-generated method stub
			super.onCreate();
			//executes when service object is created
			Toast.makeText(MyService.this, "on create", 5).show();
		}
		@Override
		public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
			// executes every time service is started
			Toast.makeText(MyService.this, "on start:"+startId, 5).show();
		return super.onStartCommand(intent, flags, startId);
		}
		
		@Override
		public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		// execute when service is stopped
		Toast.makeText(MyService.this, "on destroy", 5).show();
		}
	
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

}
