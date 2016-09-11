package com.example.multipleactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MyActivity extends Activity {
	
	EditText editNum1,editNum2;
	Button btnSum;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.main);
			
			editNum1 = (EditText) findViewById(R.id.editNum1);
			editNum2 = (EditText) findViewById(R.id.editNum2);
			btnSum = (Button) findViewById(R.id.btnSum);
			
			btnSum.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					int num1=Integer.parseInt(editNum1.getText().toString());
					int num2=Integer.parseInt(editNum2.getText().toString());
					int num3  = num1+num2;
					
													
					Intent in = new Intent(MyActivity.this, ResultActivity.class);
					in.putExtra("n1", num1);
					in.putExtra("n2", num2);
					in.putExtra("ans", num3);
					startActivity(in);
					 
					
				}
			});
			
	}
}
