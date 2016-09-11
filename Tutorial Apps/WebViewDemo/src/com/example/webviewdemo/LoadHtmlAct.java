package com.example.webviewdemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class LoadHtmlAct extends Activity {
WebView wview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		wview=(WebView) findViewById(R.id.webView1);
		//load url into webview;
		MyClient client=new MyClient();
		wview.setWebViewClient(client);
	// load your html;
		// store in a string;
		String htmlData="<html><body><h1>Welcome</h1><br><input type='text' /></body></html>";
		//wview.loadData(data, mimeType, encoding)
		wview.loadData(htmlData, "text/html","utf-16" );
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	//implement client for webview
	class MyClient extends WebViewClient
	{
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			// TODO Auto-generated method stub
			view.loadUrl(url);
			return super.shouldOverrideUrlLoading(view, url);
		}
	}
	
	@Override
		public boolean onKeyDown(int keyCode, KeyEvent event) {
			// TODO Auto-generated method stub
			if(keyCode==KeyEvent.KEYCODE_BACK)
			{
				if(wview.canGoBack())
				{
					wview.goBack();
					return true;
				}
			}
			
			return super.onKeyDown(keyCode, event);
		}
}
