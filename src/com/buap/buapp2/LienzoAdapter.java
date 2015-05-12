package com.buap.buapp2;


import android.app.Activity;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class LienzoAdapter extends BaseAdapter{
	private cab imagen;
	private Activity activity;
	private Bitmap map;
	public LienzoAdapter(Activity activity,Bitmap bm)
	{
		super();
		this.activity=activity;
		this.map=bm;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}
	
	public static class Fila
	{
		
		ImageView icono;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		Fila view;
		LayoutInflater inflador=activity.getLayoutInflater();
		if(arg1==null)
		{
			view=new Fila();
			arg1=inflador.inflate(R.layout.header, null);
			view.icono=(ImageView) arg1.findViewById(R.id.lienzo);
			view.icono.setImageBitmap(map);
			arg1.setTag(view);
		}
		else
		{
			view=(Fila) arg1.getTag();
		}
		return arg1;
	}
	
}
