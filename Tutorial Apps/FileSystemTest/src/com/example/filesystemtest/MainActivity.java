package com.example.filesystemtest;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText editMessage;
	Button btnSave,btnRead;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		editMessage=(EditText) findViewById(R.id.editMessage);
		btnSave=(Button) findViewById(R.id.btnSave);
		btnRead=(Button) findViewById(R.id.btnRead);
		
		btnRead.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String data="";
				 try 
				 {
//					InputStream is = openFileInput("sample.txt");
//					
//					while(true)
//					{
//						int i = is.read();
//						if(i==-1)
//							break;
//						data+=(char)i;
//					}
//					is.close();
//					
//					Toast.makeText(MainActivity.this, data, 5).show();
					
					 
					 //approach 2
					 
					 InputStream is = openFileInput("sample.txt");
					 InputStreamReader isr = new InputStreamReader(is);
					 BufferedReader br = new BufferedReader(isr);
					 String data2="";
					while(true)
					{
						String str = br.readLine();
						if(str==null)
							break;
						data2+=str;
					}
					
					Toast.makeText(MainActivity.this, data2, 5).show();
					 
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}
