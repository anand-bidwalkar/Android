package com.example.dilogdemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AlertRadioListAct extends Activity {
Button btnShow;
TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnShow=(Button) findViewById(R.id.button1);
		tv=(TextView) findViewById(R.id.textView1);
		
		
		btnShow.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
					AlertDialog ad=null;
					//set basic properties of alertdialog
					AlertDialog.Builder builder=
						new AlertDialog.Builder(AlertRadioListAct.this);
					
					builder.setTitle("Select your city");
					
					final String arCity[]={"Indore","bhopal","Guna","Dewas","Dhar"};
					
					builder.setSingleChoiceItems(arCity, 2, new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							String s=arCity[which];
							tv.setText(s);	
						}
					});
					builder.setPositiveButton("OK",null);
					ad=builder.create();
					ad.show();
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
