package com.example.dilogdemo;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CustomDialogAct extends Activity {
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
				// TODO Auto-generated method stub
				final Dialog dlg=new Dialog(CustomDialogAct.this);
				dlg.setTitle("Entry form");
				dlg.setContentView(R.layout.dlg_view);
				//read data from dlg box et
				final EditText etName=(EditText) dlg.findViewById(R.id.editTextName);
				Button btnOk=(Button)dlg.findViewById(R.id.buttonOk);
				
				btnOk.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
					String name=etName.getText().toString();
					tv.setText(name);
					dlg.dismiss();
					}
				});
				
				
				
				
				
				dlg.show();
				
				
				
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
