package com.example.multimediademo;

import java.io.IOException;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.media.MediaRecorder.AudioEncoder;
import android.media.MediaRecorder.AudioSource;
import android.media.MediaRecorder.OutputFormat;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class AudioRecordingAct extends Activity {
Button btnPlay, btnPause;
MediaRecorder recorder;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.video);
		
		btnPlay=(Button) findViewById(R.id.button1);
		btnPause=(Button) findViewById(R.id.button2);		
		
		// create path of audio o/p
		String path=Environment.getExternalStorageDirectory().getPath()+"/voice.mp3";
		recorder=new MediaRecorder();
		recorder.setAudioSource(AudioSource.MIC);
		recorder.setOutputFormat(OutputFormat.MPEG_4);
		recorder.setAudioEncoder(AudioEncoder.DEFAULT);
		recorder.setOutputFile(path);
		
		
		
		
		btnPlay.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			try {
				recorder.prepare();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			recorder.start();
			}
		});
btnPause.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				recorder.stop();
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
