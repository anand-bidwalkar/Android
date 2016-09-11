package com.example.uidemo3;



import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
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
		// attach listener
		AreaListener al=new AreaListener();
		buttonArea.setOnClickListener(al);
		
		PerimeterListener pl=new PerimeterListener();
		buttonPerimeter.setOnClickListener(pl);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
class AreaListener implements OnClickListener
{

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String l=etLength.getText().toString();
		String b=etBreadth.getText().toString();
		
		int length=Integer.parseInt(l);
		int breadth=Integer.parseInt(b);
		
		int area=length*breadth;
		//create popup/alert message
		//context/current activity ref, message,duration
		/*
		 * Toast t=Toast.makeText(MainActivity.this, area+"", Toast.LENGTH_LONG);
		 * t.show();
		 */
		Toast.makeText(MainActivity.this, area+"", Toast.LENGTH_LONG).show();
		
		
		
	}
	
}
class PerimeterListener implements OnClickListener
{

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String l=etLength.getText().toString();
		String b=etBreadth.getText().toString();
		
		int length=Integer.parseInt(l);
		int breadth=Integer.parseInt(b);
		
		int perimeter=2*(length+breadth);
		//create popup/alert message
		//context/current activity ref, message,duration
		/*
		 * Toast t=Toast.makeText(MainActivity.this, area+"", Toast.LENGTH_LONG);
		 * t.show();
		 */
		Toast.makeText(MainActivity.this, perimeter+"", Toast.LENGTH_LONG).show();
		
		
		
	}

}
}