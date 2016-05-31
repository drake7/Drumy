package com.example.drumy;

import com.example.drumy.R.id;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{

	TextView t1;
	Button b1;
		protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		t1=(TextView)findViewById(R.id.caption);
		b1=(Button)findViewById(R.id.button1);
		//change kr rha hu yha pe fonts
		Typeface kush=Typeface.createFromAsset(getAssets(),getString(R.string.typeface_kush));
		t1.setTypeface(kush);
	
		b1.setOnClickListener(this);
	}





	public void onClick(View v) {
		Intent myintent=new Intent(this,Drums.class);	
		startActivity(myintent);	
		finish();
		
		
	}
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
		Intent myintent=null;
		if (id == R.id.action_settings) {
		     myintent=new Intent(this,Setting.class);	
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

