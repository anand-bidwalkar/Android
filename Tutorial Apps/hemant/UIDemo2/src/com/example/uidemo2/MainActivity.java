package com.example.uidemo2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
TextView tvData;
EditText etData;
Button buttonSave;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tvData=(TextView)findViewById(R.id.textViewData);
		etData=(EditText)findViewById(R.id.editTextData);
		buttonSave=(Button)findViewById(R.id.buttonSave);
		
		SaveListener listen=new SaveListener();
		buttonSave.setOnClickListener(listen);
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	class SaveListener implements OnClickListener
	{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String s=etData.getText().toString();
			tvData.setText(s);
		}
		
	}

}
