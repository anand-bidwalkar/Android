package com.example.fragmentdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RectFragment extends Fragment 
{
	EditText etLen, etbreadth;
	Button btnArea;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//inflater.inflate(resource, root, attachToRoot)
		View fragView=inflater.inflate(R.layout.rectangle, container, false);
		
		etLen=(EditText) fragView.findViewById(R.id.editText1);
		etbreadth=(EditText) fragView.findViewById(R.id.editText2);
		btnArea=(Button) fragView.findViewById(R.id.button1);
		
		btnArea.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int l=Integer.parseInt(etLen.getText().toString());
				int b=Integer.parseInt(etbreadth.getText().toString());
				int area=l*b;
				FragmentActivity fragAct=getActivity();
				IData idata=(IData) getActivity();
				idata.setData("Area:"+area);
				Toast.makeText(fragAct, "Area:"+area, 6).show();
			}
		});
		
		return fragView;//super.onCreateView(inflater, container, savedInstanceState);
	}
}
