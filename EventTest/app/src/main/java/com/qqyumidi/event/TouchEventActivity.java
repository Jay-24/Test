package com.qqyumidi.event;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class TouchEventActivity extends Activity implements View.OnTouchListener {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		TouchEventChilds children = (TouchEventChilds) findViewById(R.id.childs);
		children.setOnTouchListener(this);
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		Log.w("eventTest", "Activity | dispatchTouchEvent --> " + TouchEventUtil.getTouchAction(ev.getAction()));
		return super.dispatchTouchEvent(ev);
		//return false;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		Log.w("eventTest", "Activity | onTouchEvent --> " + TouchEventUtil.getTouchAction(event.getAction()));
		return super.onTouchEvent(event); 
	}

	@Override
	public boolean onTouch(View view, MotionEvent ev) {
		Log.w("eventTest", "Children | onTouch --> 孩子事件监听" );
		switch (ev.getAction()) {
			case MotionEvent.ACTION_DOWN:
				Log.w("eventTest", "Children | onTouch --> 孩子事件按下" );
				break;
			case MotionEvent.ACTION_MOVE:
				Log.w("eventTest", "Children | onTouch --> 孩子事件移动" );
				break;
			case MotionEvent.ACTION_UP:
				Log.w("eventTest", "Children | onTouch --> 孩子事件抬起" );

				break;
		}
		return false;
	}
}