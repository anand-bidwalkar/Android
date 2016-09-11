package com.example.fragmentdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DynamicFragAct extends FragmentActivity implements IData 
{
Button btnRectFrag, btnCircleFrag;
FragmentManager fragManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dynamic_frags);
		btnRectFrag=(Button) findViewById(R.id.button2);
		btnCircleFrag=(Button) findViewById(R.id.button1);
		// create os version based fragment manager
		fragManager=getSupportFragmentManager();
		
		btnRectFrag.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Fragment frag=new RectFragment();
				FragmentTransaction ft=fragManager.beginTransaction();
				
				ft.replace(R.id.linearFrags, frag);
				ft.commit();
			}
		});
btnCircleFrag.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Fragment frag=new CircleFragment();
				FragmentTransaction ft=fragManager.beginTransaction();
				ft.replace(R.id.linearFrags, frag);
				ft.commit();
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void setData(String result) {
		// TODO Auto-generated method stub
		//tvResult.setText(result);
	}

}
