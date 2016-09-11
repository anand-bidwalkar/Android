package com.example.controldemo1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends Activity implements OnClickListener 
{
RadioGroup rgGen;
EditText etName, etResult;
CheckBox chkBE, chkMBA, chkMTech;
Button buttonSave;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		rgGen=(RadioGroup)findViewById(R.id.radioGroupGen);
		etName=(EditText) findViewById(R.id.editTextName);
		etResult=(EditText) findViewById(R.id.editTextResult);
		chkBE=(CheckBox) findViewById(R.id.checkBoxBe);
		chkMBA=(CheckBox) findViewById(R.id.checkBoxMBA);
		chkMTech=(CheckBox) findViewById(R.id.checkBoxMTech);
		buttonSave=(Button)findViewById(R.id.buttonSave);
		
		buttonSave.setOnClickListener(this);
		
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
		String name=etName.getText().toString();
		//find selected radio button id
		int id=rgGen.getCheckedRadioButtonId();
		String gender="";
		
		if(id==R.id.radioMale)
			gender="male";
		
		if(id==R.id.radioFemale)
			gender="female";
		
		String edu="";
		
		if(chkBE.isChecked())
			edu=edu+" BE";
		
		if(chkMBA.isChecked())
			edu=edu+" MBA";
		
		if(chkMTech.isChecked())
			edu=edu+" MTech";
		
		String data=name+":"+gender+":"+edu;
		
		etResult.setText(data);
	}

}
