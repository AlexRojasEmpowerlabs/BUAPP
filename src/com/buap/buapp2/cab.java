package com.buap.buapp2;


import android.graphics.Bitmap;

public class cab {
	private Bitmap imagen;

	public cab(Bitmap imagen)
	{
		this.imagen=imagen;
	}

	public Bitmap getIcon()
	{
		return imagen;
	}
	public void setIcon(Bitmap img)
	{
		this.imagen=img;
	}
}