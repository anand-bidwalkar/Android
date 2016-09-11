package com.example.multimediademo;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
Button btnPlay, btnPause;
MediaPlayer player;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		player=MediaPlayer.create(this, R.raw.waka);
		
		/*alternative 
		String path="/mnt/sdcard/waka.mp3";
		Uri u=Uri.parse(path);
		player=MediaPlayer.create(this, u);
		*/
		btnPlay=(Button) findViewById(R.id.button1);
		btnPause=(Button) findViewById(R.id.button2);
		
		btnPlay.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			player.start();
			}
		});
btnPause.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			player.pause();
			}
		});
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
