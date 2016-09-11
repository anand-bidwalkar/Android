package com.example.filesystemtest;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Internal_basic_MainActivity extends Activity {
	EditText editMessage;
	Button btnSave;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		editMessage=(EditText) findViewById(R.id.editMessage);
		btnSave=(Button) findViewById(R.id.btnSave);
		
		btnSave.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				 try 
				 {
					 String data = editMessage.getText().toString();
					 
					 FileOutputStream fos =  openFileOutput("sample.txt", MODE_PRIVATE);
					 byte[] mydata	= data.getBytes();
					 
					 fos.write(mydata);
					 
					 fos.close();
					 Toast.makeText(Internal_basic_MainActivity.this, "File Created", 5).show();
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
