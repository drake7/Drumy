package com.example.drumy;
import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class Spl extends Activity {
	public void onAttachedToWindow() {
		super.onAttachedToWindow();
		Window window = getWindow();
		window.setFormat(PixelFormat.RGBA_8888);
	}
	/** Called when the activity is first created. */
	Thread splashTread;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spl);
		StartAnimations();
	}
	private void StartAnimations() {
		Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
		anim.reset();
		RelativeLayout l=(RelativeLayout) findViewById(R.id.image);
		l.clearAnimation();
		l.startAnimation(anim);

		anim = AnimationUtils.loadAnimation(this, R.anim.translate);
		anim.reset();
		ImageView iv = (ImageView) findViewById(R.id.imageView12);
		iv.clearAnimation();
		iv.startAnimation(anim);

		splashTread = new Thread() {
			@Override
			public void run() {
				try {
					int waited = 0;
					// Splash screen pause time
					while (waited < 3500) {
						sleep(100);
						waited += 100;
					}
					Intent intent = new Intent(Spl.this,
							MainActivity.class);
					intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
					startActivity(intent);
					Spl.this.finish();
				} catch (InterruptedException e) {
					// do nothing
				} finally {
					Spl.this.finish();
				}

			}
		};
		splashTread.start();

	}

}