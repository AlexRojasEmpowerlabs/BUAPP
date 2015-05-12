package com.buap.buapp2;


import java.util.ArrayList;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class NavigationAdapter extends BaseAdapter{
	private Activity activity;
	private ArrayList<navObj> arrayitem;
	public NavigationAdapter(Activity activity,ArrayList<navObj> listArry)
	{
		super();
		this.activity=activity;
		this.arrayitem=listArry;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return arrayitem.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return arrayitem.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}
	
	public static class Fila
	{
		TextView titulo_itm;
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
			navObj itm= arrayitem.get(arg0);
			arg1=inflador.inflate(R.layout.itm, null);
			view.titulo_itm=(TextView) arg1.findViewById(R.id.title_item);
			view.titulo_itm.setText(itm.getTitulo());
			view.icono=(ImageView) arg1.findViewById(R.id.icon);
			view.icono.setImageResource(itm.getIcono());
			arg1.setTag(view);
		}
		else
		{
			view=(Fila) arg1.getTag();
		}
		return arg1;
	}
}
