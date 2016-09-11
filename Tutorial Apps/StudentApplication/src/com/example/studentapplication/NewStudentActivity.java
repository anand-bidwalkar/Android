package com.example.studentapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class NewStudentActivity extends Activity {
	
	EditText editRno,editName,editFees;
	Button btnSave, btnBack;
	Student s;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newstudent);
		
		editRno=(EditText) findViewById(R.id.editRno);
		editName=(EditText) findViewById(R.id.editName);
		editFees=(EditText) findViewById(R.id.editFees);
		btnSave=(Button) findViewById(R.id.btnSave);
		btnBack=(Button) findViewById(R.id.btnBack);
		
		btnBack.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
		btnSave.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				int rno= Integer.parseInt(editRno.getText().toString());
				String name = editName.getText().toString();
				float fees= Float.parseFloat(editFees.getText().toString());
				
				s = new Student(rno, name, fees);
			}
		});
	}
	
	@Override
	public void finish() {

		Intent in=new Intent();
		in.putExtra("stud", s);
		setResult(RESULT_OK, in);
		
		
		super.finish();
	}
	
}
