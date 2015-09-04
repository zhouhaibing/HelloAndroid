package com.zhb.demo.viewGroup;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class MyViewGroup extends ViewGroup{
	
	public MyViewGroup(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public MyViewGroup(Context context,AttributeSet attributeSet) {
		super(context,attributeSet);
		// TODO Auto-generated constructor stub
	}
	
	public MyViewGroup(Context context,AttributeSet attributeSet,int defStyle){
		super(context,attributeSet,defStyle);
	}

	@Override
	protected void onLayout(boolean arg0, int left, int top, int right, int bottom) {
		// TODO Auto-generated method stub
		
		/*int viewCount = getChildCount();
		for(int i=0;i<viewCount;i++){
			View v = getChildAt(i);
			v.layout(left+100, top, right, bottom);
		}*/
		int vgWidth = getMeasuredWidth();
		int vgHeight = getMeasuredHeight();// current viewgroup height
		
		int painterPosX = left;
		int painterPosY = top;// current draw cursor location
		
		int childCount = getChildCount();
		for(int i=0;i<childCount;i++){
			View childView = getChildAt(i);
			int childWidth = childView.getMeasuredWidth();
			int childHeight = childView.getMeasuredHeight();
			ViewGroup.LayoutParams viewgrouplp = childView.getLayoutParams();
			LayoutParams margins = null;
			if(viewgrouplp instanceof MyViewGroup.LayoutParams){
				margins = (MyViewGroup.LayoutParams)viewgrouplp;
				childWidth = childWidth + margins.leftMargin + margins.rightMargin;// the space with margin
				childHeight = childHeight + margins.topMargin + margins.bottomMargin;
			}
			
			//if the remaining space isn't enough, then start from second line;
			if(painterPosX + childWidth > vgWidth){
				painterPosX = left;
				painterPosY += childHeight;
			}
			// execute childView draw
			if(margins != null){
				childView.layout(painterPosX + margins.leftMargin, painterPosY + margins.topMargin ,
						painterPosX + childWidth - margins.rightMargin, painterPosY +  childHeight - margins.bottomMargin);
			}else{
				childView.layout(painterPosX, painterPosY,
						painterPosX  + childWidth, painterPosY  + childHeight);
			}
			
			painterPosX += childWidth;
		}
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		measureChildren(widthMeasureSpec, heightMeasureSpec);
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);	
	}

	
	public static class LayoutParams extends ViewGroup.MarginLayoutParams{

		public LayoutParams(Context c, AttributeSet attrs) {
			super(c, attrs);
			// TODO Auto-generated constructor stub
		}
	
	}
	
	@Override
	public android.view.ViewGroup.LayoutParams generateLayoutParams(
			AttributeSet attrs) {
		// TODO Auto-generated method stub
		return new MyViewGroup.LayoutParams(getContext(), attrs);
	}
	
	
	
	/** 
     * 为控件添加边框 
     */  
    /*@Override  
    protected void dispatchDraw(Canvas canvas) {  
        // 获取布局控件宽高  
        int width = getWidth();  
        int height = getHeight();  
        // 创建画笔  
        Paint mPaint = new Paint();  
        // 设置画笔的各个属性  
        mPaint.setColor(Color.BLUE);  
        mPaint.setStyle(Paint.Style.STROKE);  
        mPaint.setStrokeWidth(10);  
        mPaint.setAntiAlias(true);  
        // 创建矩形框  
        Rect mRect = new Rect(0, 0, width, height);  
        // 绘制边框  
        canvas.drawRect(mRect, mPaint);  
        // 最后必须调用父类的方法  
        super.dispatchDraw(canvas);  
    }  */
	
}
