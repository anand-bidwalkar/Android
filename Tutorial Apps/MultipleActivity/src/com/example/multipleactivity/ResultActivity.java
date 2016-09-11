package com.example.multipleactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends Activity {
	
	TextView tvResult;
	 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resultview);
		
		Intent in = getIntent();
		int n1 = in.getExtras().getInt("n1");
		int n2 = in.getExtras().getInt("n2");
		int result = in.getExtras().getInt("ans");
		
		
		tvResult=(TextView) findViewById(R.id.tvResult);
		tvResult.setText("Sum of "+n1+" and "+n2 +" is "+result);
	}
}
