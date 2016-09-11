package com.example.dynamiccompo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity {

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
		lay_inner.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,200));
		//lay_inner.setBackgroundColor(Color.GRAY);
		lay_inner.setOrientation(LinearLayout.VERTICAL);
		
			
		lay_main.addView(lay_btn);
		lay_main.addView(lay_inner);
		
		
		
		setContentView(lay_main);
		
		b2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				lay_inner.removeAllViews();
				LayoutInflater linf = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
				View v2 = linf.inflate(R.layout.forcircle, null);
				
				final EditText editR = (EditText) v2.findViewById(R.id.editRadius);
				Button b = (Button) v2.findViewById(R.id.btnArea);
				b.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						float r = Float.parseFloat(editR.getText().toString());
						float a = 3.14f*r*r;
						Toast.makeText(getApplicationContext(), "Area is : "+a,	5).show();
					}
				});
				
				
				lay_inner.addView(v2);
				
				
				
				
			}
		});
		
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				lay_inner.removeAllViews();
				
				LayoutInflater linf = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
				View v2 = linf.inflate(R.layout.forrect, null);
				lay_inner.addView(v2);
			
			}
		});
	}
}
