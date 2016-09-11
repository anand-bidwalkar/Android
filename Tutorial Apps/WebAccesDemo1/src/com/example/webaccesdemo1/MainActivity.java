package com.example.webaccesdemo1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	Button btnDownload;
	String url = "http://static.cricinfo.com/rss/livescores.xml";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnDownload = (Button) findViewById(R.id.button1);
		btnDownload.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				NetworkThread thread=new NetworkThread();
				thread.start();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	class NetworkThread extends Thread {
		@Override
		public void run() 
		{
			// create http connection with Server;
			DefaultHttpClient client=new DefaultHttpClient();
			//create a request object;
			HttpGet get=new HttpGet(url);
			// send request
			try {
			HttpResponse response=client.execute(get);
			// read data from response
			InputStream is=response.getEntity().getContent();
			// convert stream in character stream;
			InputStreamReader isr=new InputStreamReader(is);
			//convert char reader into line reader;
			BufferedReader br=new BufferedReader(isr);
			// create file to store
			
			File sdPath=Environment.getExternalStorageDirectory();
			String filePath=sdPath.getPath()+"/score.xml";
			FileWriter fw=new FileWriter(filePath);
			
			while(true)
			{
				String s=br.readLine();
				if(s==null)
					break;
				else
				{
					Log.e("score:", s);
					fw.write(s+"\n");
				}
			}
			br.close();
			fw.flush();
			fw.close();
			
			
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}

}
