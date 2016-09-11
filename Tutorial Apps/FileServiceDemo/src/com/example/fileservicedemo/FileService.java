package com.example.fileservicedemo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import android.app.Service;
import android.content.Intent;
import android.os.Environment;
import android.os.IBinder;
import android.widget.Toast;

public class FileService extends Service 
{
	String filePath="";
	
@Override
public void onCreate() {
	// TODO Auto-generated method stub
	super.onCreate();
	File sdCard=Environment.getExternalStorageDirectory();
	filePath=sdCard.getPath()+"/data.txt";
	
	
}
@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		String d=intent.getStringExtra("data");
		
		try {
			FileWriter fw=new FileWriter(filePath,true);
			fw.write(d);
			fw.flush();
			fw.close();
			Toast.makeText(FileService.this, "saved..",3).show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	return super.onStartCommand(intent, flags, startId);
		
		
	}	
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

}
