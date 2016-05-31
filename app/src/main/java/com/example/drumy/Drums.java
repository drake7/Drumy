package com.example.drumy;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class Drums extends Activity implements OnClickListener{

	ImageView i1,i2,i3,i4,i5,i6;
	MediaPlayer mp;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_drums);
	i1=(ImageView)findViewById(R.id.imageView1);
	i2=(ImageView)findViewById(R.id.imageView2);
	i3=(ImageView)findViewById(R.id.imageView3);
	i4=(ImageView)findViewById(R.id.imageView4);
	i5=(ImageView)findViewById(R.id.imageView5);
	i6=(ImageView)findViewById(R.id.imageView6);
	i1.setOnClickListener(this);
	i2.setOnClickListener(this);
	i3.setOnClickListener(this);
	i4.setOnClickListener(this);
	i5.setOnClickListener(this);
	i6.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) 
	{
	if(v.getId()==R.id.imageView1)
	{
    mediaplay(R.raw.mostlo);
	}
	if(v.getId()==R.id.imageView2)
	{
    mediaplay(R.raw.floor);
	}
	if(v.getId()==R.id.imageView3)
	{
    mediaplay(R.raw.low);
	}
	if(v.getId()==R.id.imageView4)
	{
    mediaplay(R.raw.lower);
	}
	if(v.getId()==R.id.imageView5)
	{
    mediaplay(R.raw.lowest);
	}
	if(v.getId()==R.id.imageView6)
	{
    mediaplay(R.raw.snare);
	}
	}
	protected void onResume() {
		if(mp!=null)
		{
			
			mp.start();
		}

		super.onResume();
	}
	
	protected void onPause() {
	if(mp.isPlaying())
	{
		mp.pause();
	}
		super.onPause();
	}
	void mediaplay(int sound)
	{
	if(mp!=null && mp.isPlaying())
	{
	mp.stop();	
	mp.release();
	}
	mp=MediaPlayer.create(getBaseContext(),sound);
	mp.start();
	}
	
}