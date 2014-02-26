package com.fei.exercicemaster.ui;

import com.fei.exercicemaster.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.widget.RelativeLayout;

public class SplashActivity extends Activity {
	private RelativeLayout sp_main;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		sp_main = (RelativeLayout) findViewById(R.id.sp_main);
		
		AlphaAnimation aa = new AlphaAnimation(0, 1);
		aa.setDuration(2000);
		sp_main.setAnimation(aa);
		
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				
				LoadMainPage();
				
				finish();
			}
		}, 2000);
		
	}

	
	private void LoadMainPage (){
		Intent intent = new Intent(this, MainListActivity.class);
		startActivity(intent);
	}

}
