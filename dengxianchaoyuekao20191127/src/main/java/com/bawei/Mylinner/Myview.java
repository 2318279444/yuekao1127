package com.bawei.Mylinner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/*
 *@auther:邓先超
 *@Date: 2019/11/27
 *@Time:11:10
 *@Description:${DESCRIPTION}
 **/
public class Myview extends ViewGroup {
    public Myview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int space=10;
        int left=0;
        int top=0;
        int right=0;
        int buttom=0;
        int width = getWidth();
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View childAt = getChildAt(i);
            childAt.measure(0,0);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            left=right+space;
            right=left+measuredWidth;
            if(right>width){
                top=buttom+space;
                left=space;
            }
            right=left+measuredWidth;
            buttom=top+measuredHeight;
            childAt.layout(left,top,right,buttom);
        }
    }
}
