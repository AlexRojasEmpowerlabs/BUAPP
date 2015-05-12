package com.buap.buapp2;

import java.lang.reflect.InvocationTargetException;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebViewClient;
import android.widget.ZoomButtonsController;

public class WebActivity extends Activity {

	Bundle bnd;
	String url;
	WebView web;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web);
		web=(WebView) findViewById(R.id.webs);
		bnd=getIntent().getExtras();
		url=bnd.getString("url");
		web.loadUrl(url);
		web.getSettings().setJavaScriptEnabled(true);
		// web.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
		
		web.getSettings().setPluginState(PluginState.ON);

		// ---you need this to prevent the webview from
		// launching another browser when a url
		// redirection occurs---
		web.setWebViewClient(new WebViewClient());

		// getActivity().setContentView(web);
		web.getSettings().setSupportZoom(true);
		web.getSettings().setBuiltInZoomControls(true);
		if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
			// Use the API 11+ calls to disable the controls
			// Use a seperate class to obtain 1.6 compatibility
			new Runnable() {
				public void run() {
					web.getSettings().setDisplayZoomControls(false);
				}
			}.run();
		} else {
			ZoomButtonsController zoom_controll = null;
			try {
				zoom_controll = (ZoomButtonsController) web.getClass()
						.getMethod("getZoomButtonsController")
						.invoke(web, null);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			zoom_controll.getContainer().setVisibility(View.GONE);
		}


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.web, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
