package com.example.studentapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button btnAdd,btnShow;
	Student s;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnAdd=(Button) findViewById(R.id.btnAdd);
		btnShow=(Button) findViewById(R.id.btnShow);
		
		btnAdd.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent in =new Intent(MainActivity.this, NewStudentActivity.class);
				//startActivity(in);
				startActivityForResult(in, 101);
				
			}
		});
		btnShow.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent in =new Intent(MainActivity.this, ShowStudentActivity.class);
				in.putExtra("stud", s);
				//startActivity(in);
				startActivityForResult(in, 102);
			}
		});
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		if(requestCode==101 && resultCode==RESULT_OK)
		{
			 s = (Student) data.getSerializableExtra("stud");
			Toast.makeText(MainActivity.this, "Hello "+s.getName(), 5).show();
		}
			
		
	}
}
