
package edu.hrbeu.HelloAndroid;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    // 定义浮动窗口布局
    LinearLayout mFloatLayout;
    WindowManager.LayoutParams wmParams;
    // 创建浮动窗口设置布局参数的对象
    WindowManager mWindowManager;

    Button mFloatView;

    private static final String TAG = "FxService";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        /*Button btn = new Button(getApplicationContext());
        btn.setText("hello");

        RelativeLayout rl = new RelativeLayout(this);
        // 设置RelativeLayout布局的宽高
        RelativeLayout.LayoutParams relLayoutParams = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        TextView temp = new TextView(this);
        temp.setId(1);
        temp.setText("photo");
        rl.addView(temp);

        Button startFloat = new Button(this);
        startFloat.setText("启动悬浮窗");
        Button stopFloat = new Button(this);
        stopFloat.setText("停止悬浮窗");
        rl.addView(startFloat);
        // rl.addView(stopFloat, 2);
        startFloat.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // Intent intent = new
                // Intent(MainActivity.this,FloatViewService.class);
                // startService(intent);
                createFloatView();
            }

        });
        stopFloat.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // Intent intent = new
                // Intent(MainActivity.this,FloatViewService.class);
                // stopService(intent);
            }

        });
        this.addContentView(rl, relLayoutParams);*/
        

    }

    private void createFloatView() {
        wmParams = new WindowManager.LayoutParams();
        // 获取的是WindowManagerImpl.CompatModeWrapper
        // mWindowManager =
        // (WindowManager)getApplication().getSystemService(getApplication().WINDOW_SERVICE);
        // mWindowManager =
        // (WindowManager)getApplication().getSystemService(getApplication().WINDOW_SERVICE);
        mWindowManager = this.getWindowManager();
        Log.i(TAG, "mWindowManager--->" + mWindowManager);
        // 设置window type
        wmParams.type = LayoutParams.TYPE_PHONE;
        // wmParams.type = LayoutParams.TYPE_APPLICATION;
        // 设置图片格式，效果为背景透明
        wmParams.format = PixelFormat.RGBA_8888;
        // 设置浮动窗口不可聚焦（实现操作除浮动窗口外的其他可见窗口的操作）
        wmParams.flags = LayoutParams.FLAG_NOT_FOCUSABLE;
        // 调整悬浮窗显示的停靠位置为左侧置顶
        wmParams.gravity = Gravity.LEFT | Gravity.TOP;
        // 以屏幕左上角为原点，设置x、y初始值，相对于gravity
        wmParams.x = 0;
        wmParams.y = 0;

        // 设置悬浮窗口长宽数据
        wmParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        wmParams.height = WindowManager.LayoutParams.WRAP_CONTENT;

        /*
         * // 设置悬浮窗口长宽数据 wmParams.width = 200; wmParams.height = 80;
         */

        LayoutInflater inflater = LayoutInflater.from(getApplication());
        // 获取浮动窗口视图所在布局
        // mFloatLayout = (LinearLayout) inflater.inflate(, null);
        mFloatLayout = new LinearLayout(this);
        Button btn = new Button(this);
        btn.setText("hello");
        mFloatLayout.addView(btn);
        // 添加mFloatLayout
         mWindowManager.addView(mFloatLayout, wmParams);
        // 浮动窗口按钮
        mFloatView = btn;

        mFloatLayout.measure(View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED), View.MeasureSpec
                .makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        Log.i(TAG, "Width/2--->" + mFloatView.getMeasuredWidth() / 2);
        Log.i(TAG, "Height/2--->" + mFloatView.getMeasuredHeight() / 2);
        // 设置监听浮动窗口的触摸移动
        mFloatView.setOnTouchListener(new OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                // getRawX是触摸位置相对于屏幕的坐标，getX是相对于按钮的坐标
                
                wmParams.x = (int) event.getRawX()
                        - mFloatView.getMeasuredWidth()/2;
                // - mFloatView.getMeasuredWidth()/2 -
                // mFloatView.getMeasuredHeight()/2 - 25
                Log.i(TAG, "RawX" + event.getRawX());
                Log.i(TAG, "X" + event.getX());
                // 减25为状态栏的高度
                wmParams.y = (int) event.getRawY()
                        - mFloatView.getMeasuredHeight()/2 - 25;
                Log.i(TAG, "RawY" + event.getRawY());
                Log.i(TAG, "Y" + event.getY());
                // 刷新
                mWindowManager.updateViewLayout(mFloatLayout, wmParams);
                return false; // 此处必须返回false，否则OnClickListener获取不到监听
            }
        });
        
        Button bbb = new Button(this);
        bbb.setText("bbbbb");
        Button bbb1 = new Button(this);
        bbb1.setText("bbbbb1");
        LinearLayout ll = new LinearLayout(this);
        ll.addView(bbb);
        ll.addView(bbb1);
        //mWindowManager.addView(ll,wmParams);
        
        mFloatView.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(MainActivity.this, "onClick", Toast.LENGTH_SHORT)
                        .show();
                // new
                // AlertDialog.Builder(MainActivity.this).setTitle("系統提示").setMessage("please sure it").show();

            }
        });
    }

   
}
