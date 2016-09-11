package com.example.multipleactivity2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends Activity {
	
	TextView tvResult;
	Button btnUpdate,btnBack;
	 int result;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resultview);
		
		btnBack=(Button) findViewById(R.id.btnBack);
		btnUpdate=(Button) findViewById(R.id.btnUpdate);
		
		
		Intent in = getIntent();
		int n1 = in.getExtras().getInt("n1");
		int n2 = in.getExtras().getInt("n2");
		result = in.getExtras().getInt("ans");
		
		
		tvResult=(TextView) findViewById(R.id.tvResult);
		//tvResult.setText("Sum of "+n1+" and "+n2 +" is "+result);
		tvResult.setText(result+"");
		
		
		btnUpdate.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				result++;
				tvResult.setText(result+"");
			}
		});
		
		btnBack.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				
				finish();
			}
		});
	}
	
	
	@Override
	public void finish() {


		Intent in=new Intent();
		in.putExtra("retval", result);
		
		setResult(RESULT_OK,in);
		
		super.finish();
	}
}
