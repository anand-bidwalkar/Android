package com.example.studentapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowStudentActivity extends Activity {
	
	TextView tvRno,tvName,tvFees;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.showstudent);
		
		tvRno=(TextView) findViewById(R.id.tvRno);
		tvName=(TextView) findViewById(R.id.tvName);
		tvFees=(TextView) findViewById(R.id.tvFees);
		
		Intent in = getIntent();
		Student s = (Student) in.getSerializableExtra("stud");
		
		tvRno.setText(s.getRno()+"");
		tvName.setText(s.getName());
		tvFees.setText(s.getFees()+"");
		
	}
}
