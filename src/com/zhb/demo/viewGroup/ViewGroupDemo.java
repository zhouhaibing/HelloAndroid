package com.zhb.demo.viewGroup;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ViewGroupDemo extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		/*LinearLayout outerLL = new LinearLayout(this);
		outerLL.addView(littleWidget());*/

		/*MyViewGroup vg = new MyViewGroup(this);
		Button btn = new Button(this);
		btn.setText("hello");
		vg.addView(btn);
		setContentView(vg);*/
		
		setContentView(R.layout.viewgroup_main1);
		MyViewGroup vg = (MyViewGroup)findViewById(R.id.myviewgroup);
		vg.setBackgroundColor(Color.GRAY);
		
		for (int i = 0; i < 7; i++) {  
            //CheckBox box = new CheckBox(this);
            //box.setText("第"+i);  
			Button btn = new Button(this);
			btn.setText("第" +i + "个");
			LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
			lp.setMargins(20, 80, 20, 20);
			btn.setLayoutParams(lp);
            vg.addView(btn);  
        }
	}
	
	public ViewGroup viewGroup(){
		ViewGroup vg = new MyViewGroup(this);
		ImageView iv1 = new ImageView(this);
		iv1.setBackgroundResource(R.drawable.ic_launcher);
		vg.setBackgroundColor(Color.GREEN);
		
		Button btn = new Button(this);
		btn.setText("hello");
		btn.setBackgroundColor(Color.RED);
		
		LinearLayout ll = new LinearLayout(this);
		ll.setBackgroundColor(Color.BLUE);
		ll.setOrientation(LinearLayout.HORIZONTAL);
		ll.addView(btn);
		ll.addView(iv1);
		
		vg.addView(ll);
		return vg;
	}
	
	public LinearLayout littleWidget(){//the outer layout of ll is necessary
		LinearLayout ll = new LinearLayout(this);
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT);
		ll.setLayoutParams(lp);
		ll.setOrientation(LinearLayout.HORIZONTAL);
		ll.setBackgroundColor(Color.WHITE);
		ImageView iv = new ImageView(this);
		iv.setMinimumHeight(52);
		iv.setBackgroundResource(R.drawable.ic_launcher);
		//ll.addView(iv);
		
		Button btn = new Button(this);
		btn.setText("xxxx");
		ll.addView(btn);
		ll.addView(iv);
		
		return ll;
	}

}
