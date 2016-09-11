package com.example.dynamiccompo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Dyn_MainActivity extends Activity {

	LinearLayout lay_main,lay_inner,lay_btn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
		
		lay_main=new LinearLayout(this);
		lay_main.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		lay_main.setOrientation(LinearLayout.VERTICAL);
			
		lay_btn=new LinearLayout(this);
		lay_btn.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		
		Button b1 = new Button(this);
		b1.setText("Rectangle");
		final LayoutParams btnlp=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		b1.setLayoutParams(btnlp);
		
		Button b2 = new Button(this);
		b2.setText("Circle");
		b2.setLayoutParams(btnlp);
		
		lay_btn.addView(b1);
		lay_btn.addView(b2);
		
		
		
		lay_inner=new LinearLayout(this);
		lay_inner.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		//lay_inner.setBackgroundColor(Color.GRAY);
		lay_inner.setOrientation(LinearLayout.VERTICAL);
		
			
		lay_main.addView(lay_btn);
		lay_main.addView(lay_inner);
		
		
		
		setContentView(lay_main);
		
		b2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				lay_inner.removeAllViews();
				
				EditText editL=new EditText(Dyn_MainActivity.this);
				editL.setHint("Enter Radius");
				editL.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				Button btnArea = new Button(Dyn_MainActivity.this);
				btnArea.setLayoutParams(btnlp);
				btnArea.setText("Area");
				
				lay_inner.addView(editL);
				lay_inner.addView(btnArea);
			}
		});
		
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				lay_inner.removeAllViews();
				
				EditText editL=new EditText(Dyn_MainActivity.this);
				editL.setHint("Enter L");
				editL.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				EditText editB=new EditText(Dyn_MainActivity.this);
				editB.setHint("Enter B");
				editB.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				Button btnArea = new Button(Dyn_MainActivity.this);
				btnArea.setLayoutParams(btnlp);
				btnArea.setText("Area");
				
				lay_inner.addView(editL);
				lay_inner.addView(editB);
				lay_inner.addView(btnArea);
				
				
				Toast.makeText(getApplicationContext(), "Dynamic button Clicked", 5).show();
			}
		});
	}
}
