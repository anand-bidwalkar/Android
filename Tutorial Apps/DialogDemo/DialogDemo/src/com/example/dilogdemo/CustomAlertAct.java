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

public class CustomAlertAct extends Activity {
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
						new AlertDialog.Builder(CustomAlertAct.this);
					
					builder.setTitle("Movie today?");
					builder.setMessage("which?");
					builder.setIcon(R.drawable.ic_launcher);
					//attach xml view with dialog
					LayoutInflater inf=(LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
					View dlg_view=inf.inflate(R.layout.alert_dlg_view, null);
					builder.setView(dlg_view);
					
					final EditText etMovie=(EditText) 
					     dlg_view.findViewById(R.id.editTextMovie);
					
									
					builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							String movie=etMovie.getText().toString();
							tv.setText(movie);
						}
					});
					builder.setNegativeButton("Later", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							Toast.makeText(CustomAlertAct.this,
									"See u next time..", 5).show();
						}
					});
					
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
