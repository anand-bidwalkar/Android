package com.example.fragmentdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CircleFragment extends Fragment 
{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//inflater.inflate(resource, root, attachToRoot)
		View fragView=inflater.inflate(R.layout.circle, container, false);
		return fragView;//super.onCreateView(inflater, container, savedInstanceState);
	}
}
