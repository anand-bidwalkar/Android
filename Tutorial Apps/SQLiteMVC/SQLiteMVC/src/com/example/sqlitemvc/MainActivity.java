package com.example.sqlitemvc;

import controller.StudentManager;
import model.MyHelper;
import model.Student;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText editRno,editName,editFees;
	Button btnSave;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		editRno=(EditText) findViewById(R.id.editRno);
		editName=(EditText) findViewById(R.id.editName);
		editFees=(EditText) findViewById(R.id.editFees);

		btnSave=(Button) findViewById(R.id.btnSave);
		btnSave.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				int rno = Integer.parseInt(editRno.getText().toString());
				String name = editName.getText().toString();
				float fees = Float.parseFloat(editFees.getText().toString());
				
				Student s = new Student(rno, name, fees);
				
				StudentManager sm = new StudentManager(MainActivity.this);
				sm.newStudent(s);
				
				Toast.makeText(MainActivity.this, "Student Added", 5).show();
			}
		});
	}

}
