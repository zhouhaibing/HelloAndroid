package edu.hrbeu.HelloAndroid;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HelloAndroidActivity extends Activity {
    /** Called when the activity is first created. */
	
	WindowManager mWindowManager;
	WindowManager.LayoutParams wmParams;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        //mWindowManager = this.getWindowManager();
        mWindowManager =  (WindowManager)getApplication().getSystemService(getApplication().WINDOW_SERVICE);
        wmParams = new WindowManager.LayoutParams();
        wmParams.type = LayoutParams.TYPE_PHONE;
        // wmParams.type = LayoutParams.TYPE_APPLICATION;
        // 设置图片格式，效果为背景透明
        wmParams.format = PixelFormat.RGBA_8888;
        // 设置浮动窗口不可聚焦（实现操作除浮动窗口外的其他可见窗口的操作）
        wmParams.flags = LayoutParams.FLAG_NOT_FOCUSABLE;
        // 调整悬浮窗显示的停靠位置为左侧置顶
        wmParams.gravity = Gravity.LEFT | Gravity.TOP;
        // 以屏幕左上角为原点，设置x、y初始值，相对于gravity
        wmParams.x = 130;
        wmParams.y = 130;

        // 设置悬浮窗口长宽数据
        wmParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        wmParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        
        
        LinearLayout ll = new LinearLayout(this);
        final Button b1 = new Button(this);
        b1.setText("btn1");
        Button b2 = new Button(this);
        b2.setText("btn2");
        ll.addView(b1);
        ll.addView(b2);
        mWindowManager.addView(ll, wmParams);
        
        b2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(b1.getVisibility() == TextView.VISIBLE)
					b1.setVisibility(TextView.INVISIBLE);
				else
					b1.setVisibility(TextView.VISIBLE);
			}
		});
    }
}