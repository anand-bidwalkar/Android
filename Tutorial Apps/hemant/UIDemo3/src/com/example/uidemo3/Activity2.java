package com.example.uidemo3;



import com.example.uidemo3.MainActivity.AreaListener;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity2 extends Activity implements OnClickListener 
{
EditText etLength, etBreadth;
Button buttonArea, buttonPerimeter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		buttonArea=(Button)findViewById(R.id.button2);
		buttonPerimeter=(Button)findViewById(R.id.button1);
		etBreadth=(EditText)findViewById(R.id.editText2);
		etLength=(EditText)findViewById(R.id.editText1);
		
		
		buttonArea.setOnClickListener(this);
		buttonPerimeter.setOnClickListener(this);
		
		Toast.makeText(this,"I am actvity 2", Toast.LENGTH_SHORT).show();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		// get the id of view clicked
		int id=v.getId();
		switch (id) {
		case R.id.button2:
			String l=etLength.getText().toString();
			String b=etBreadth.getText().toString();
			
			int length=Integer.parseInt(l);
			int breadth=Integer.parseInt(b);
			
			int area=length*breadth;
			Toast.makeText(this, area+"", Toast.LENGTH_LONG).show();
			
			break;

		case R.id.button1:
			String l1=etLength.getText().toString();
			String b1=etBreadth.getText().toString();
			
			int length1=Integer.parseInt(l1);
			int breadth1=Integer.parseInt(b1);
			
			int perimeter=2*(length1+breadth1);
			Toast.makeText(this, perimeter+"", Toast.LENGTH_LONG).show();
			
			break;

		default:
			break;
		}
		
	}

}