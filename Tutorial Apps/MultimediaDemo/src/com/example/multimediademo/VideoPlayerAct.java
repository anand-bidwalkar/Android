package com.example.multimediademo;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlayerAct extends Activity {
Button btnPlay, btnPause;
VideoView videoView;
MediaController mController;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.video);
		videoView=(VideoView) findViewById(R.id.videoView1);		
		btnPlay=(Button) findViewById(R.id.button1);
		btnPause=(Button) findViewById(R.id.button2);		
		
		// attach path of video to videoView
		String path=Environment.getExternalStorageDirectory().getPath()+"/tech.3gp";
		videoView.setVideoPath(path);
		mController=new MediaController(this);
		videoView.setMediaController(mController);
		videoView.start();
		
		btnPlay.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			videoView.start();
			}
		});
btnPause.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				videoView.pause();
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
