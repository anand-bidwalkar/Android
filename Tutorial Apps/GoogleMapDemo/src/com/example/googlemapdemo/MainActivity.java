package com.example.googlemapdemo;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends Activity 
{
GoogleMap gmap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		FragmentManager fm=getFragmentManager();
		Fragment frag= fm.findFragmentById(R.id.map);
		MapFragment mapFrag=(MapFragment) frag;
		gmap=mapFrag.getMap();
		
		// creat a marker;
		LatLng myLoc=new LatLng(22.762886,75.893555);
		MarkerOptions marker1=new MarkerOptions();
		marker1.title("My location s here");
		marker1.snippet("I will be here for some time");
		marker1.position(myLoc);
		
		gmap.addMarker(marker1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
