package com.buap.buapp2;

import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.app.WallpaperManager;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.os.Build;



public class MainActivity extends ActionBarActivity {
	
	private static DrawerLayout navDrawer;
	private static ListView navList;
	private static ArrayList<navObj> navItm;
	private static TypedArray navIcon;
	private static String[] titulos;
	private static NavigationAdapter navAdapter;
	private static ActionBarDrawerToggle drawerToogle;
	public static ActionBar actionBar;
	public static WebView web;
	public static WallpaperManager wallpaperManager;
	public static Drawable wallpaperDrawable;
	public static LinearLayout  linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.bar));
        actionBar.setDisplayHomeAsUpEnabled(true);


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (item != null && item.getItemId() == android.R.id.home) {
            if (navDrawer.isDrawerOpen(Gravity.RIGHT)) {
                navDrawer.closeDrawer(Gravity.RIGHT);
            } else {
                navDrawer.openDrawer(Gravity.RIGHT);
            }
        }
        if (id == R.id.action_settings) {
        	Intent sig=new Intent(this,DesarrolladorActivity.class);
        	hilo(sig);
        }/*if (drawerToogle.onOptionsItemSelected(item)) {
			return true;
		}*/
        return super.onOptionsItemSelected(item);
    }
    
    public void next(View v){
    	Intent sig=new Intent(this,WebActivity.class);
    	String url="";
    	switch(v.getId()){
    	case R.id.btn1:
    		break;
    	case R.id.btn2:
    		url="https://www.google.com/maps/d/viewer?msa=0&mid=zHfWTbleKCpQ.ko1oN2GGdphI";
        	sig.putExtra("url", url);
        	hilo(sig);
    		break;
    	case R.id.btn3:
    		url="http://webserver1.siiaa.siu.buap.mx:81/autoservicios/twbkwbis.P_WWWLogin";
        	sig.putExtra("url", url);
        	hilo(sig);
    		break;
    	case R.id.btn4:
    		url="";
    		break;
    	case R.id.btn5:
    		url="http://www.facultaddelenguas.com/cele/";
        	sig.putExtra("url", url);
        	hilo(sig);
    		break;
    	case R.id.btn6:
    		url="http://www.bibliotecas.buap.mx/portal/";
        	sig.putExtra("url", url);
        	hilo(sig);
    		break;
    	case R.id.btn7:
    		url="http://www.complejocultural.buap.mx/";
        	sig.putExtra("url", url);
        	hilo(sig);
    		break;
    	case R.id.btn8:
    		url="http://www.clublobosbuap.com/";
        	sig.putExtra("url", url);
        	hilo(sig);
    		break;
    	case R.id.btn9:
    		url="";
    		break;
    	}
    }
    
    public void hilo(final Intent actividad){
    	Thread tr=new Thread(){
			String t="";
			@Override
			public void run(){

	        	startActivity(actividad);

				runOnUiThread(new Runnable(){
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
					}});
				
			}
		};tr.start();
		
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }

		@Override
        public void onActivityCreated(Bundle state) {
            super.onActivityCreated(state);

            wallpaperManager= WallpaperManager.getInstance(getActivity());
        	wallpaperDrawable = wallpaperManager.getDrawable();
        	linearLayout = (LinearLayout) getActivity().findViewById(R.id.frame);
        	linearLayout.setBackground(wallpaperDrawable);
            navDrawer=(DrawerLayout) getActivity().findViewById(R.id.navLayout);
    		navList=(ListView) getActivity().findViewById(R.id.it);
    		View header=getActivity().getLayoutInflater().inflate(R.layout.header,null);
    		navList.addHeaderView(header);
    		navIcon=getResources().obtainTypedArray(R.array.nav_icon);
    		titulos=getResources().getStringArray(R.array.element_laterales);
    		
    		
    		
    		navItm=new ArrayList<navObj>();
    		
    		navItm.add(new navObj(titulos[0],navIcon.getResourceId(1, 0)));
    		navItm.add(new navObj(titulos[1],navIcon.getResourceId(2, 0)));
    		navItm.add(new navObj(titulos[2],navIcon.getResourceId(0, 0)));
    		navItm.add(new navObj(titulos[3],navIcon.getResourceId(0, 0)));
    		
    		navAdapter=new NavigationAdapter(getActivity(),navItm);
    		navList.setAdapter(navAdapter);
    		drawerToogle = new ActionBarDrawerToggle(getActivity(), navDrawer,
					R.drawable.ic_launcher, R.string.app_name,
					R.string.app_name) {
				@Override
				public void onDrawerClosed(View v) {
					actionBar.setIcon(getResources().getDrawable(
							R.drawable.ic_launcher));
					actionBar.setHomeButtonEnabled(true);
					actionBar.setSubtitle(null);

				}

				@Override
				public void onDrawerOpened(View v) {

					actionBar.setIcon(getResources().getDrawable(
							R.drawable.ic_launcher));
					actionBar.setSubtitle("Menu");
					actionBar.setDisplayHomeAsUpEnabled(true);

				}
			};

			navDrawer.setDrawerListener(drawerToogle);
			web=(WebView)getActivity().findViewById(R.id.test);
			web.getSettings().setJavaScriptEnabled(true);
			web.loadUrl("http://alexrojas.cloudapp.net/web/negocio/ads.html");

		}
	
    }
}
