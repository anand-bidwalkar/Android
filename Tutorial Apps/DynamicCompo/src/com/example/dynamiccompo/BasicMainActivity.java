package com.example.dynamiccompo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class BasicMainActivity extends Activity {

	LinearLayout lay_main;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
		
		lay_main=new LinearLayout(this);
		lay_main.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
			
		
		Button b1 = new Button(this);
		b1.setText("Click Here");
		LayoutParams btnlp=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		b1.setLayoutParams(btnlp);
		
		
		lay_main.addView(b1);
		
		setContentView(lay_main);
		b1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "Dynamic button Clicked", 5).show();
			}
		});
	}
}
