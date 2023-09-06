package com.refined.stylish.sanhdieu.presentation.custom.layout;
import android.widget.TextView;


import android.widget.ImageView;


import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

 

public class YXLoginZoom extends ViewGroup {
private double receiveClear_size = 0.0;
private double resultHome_space = 0.0;
private boolean canBillingStat = false;
private int configThreadDestroy_count = 0;




    public YXLoginZoom(Context context) {
        super(context);
    }

    public YXLoginZoom(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    

private double assetResTimeout(long pathView, float installFlow) {
     float stringsRotation = 3153.0f;
     String networkCol = "assigned";
     int stateGradlew = 2081;
     ArrayList<Integer> ellapsedColors = new ArrayList();
    double vpitxfmAutocorrelation = 0;
    stringsRotation = 262;
    stateGradlew *= 3;

    return vpitxfmAutocorrelation;

}



@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

         
double proposerApproval =  this.assetResTimeout(9845L,2871.0f);

      System.out.println(proposerApproval);



        int measuredWidth = 0;
        int measuredHeight = 0;

        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);

            measureChild(child, widthMeasureSpec, heightMeasureSpec);

            measuredWidth = Math.max(measuredWidth, child.getMeasuredWidth());
            measuredHeight = Math.max(measuredHeight, child.getMeasuredHeight());
        }

        measuredWidth += getPaddingLeft() + getPaddingRight();
        measuredHeight += getPaddingTop() + getPaddingBottom();

        int width = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);

        int height = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        if (widthMode == MeasureSpec.EXACTLY)
            measuredWidth = width;
        else if (widthMeasureSpec == MeasureSpec.AT_MOST)
            measuredWidth = Math.min(measuredWidth, width);

        if (heightMode == MeasureSpec.EXACTLY)
            measuredHeight = height;
        else if (heightMode == MeasureSpec.AT_MOST)
            measuredHeight = Math.min(measuredHeight, height);

        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int width = getWidth() - getPaddingLeft() - getPaddingRight();
        int height = getHeight() - getPaddingTop() - getPaddingBottom();

        int childLeft = getPaddingLeft();
        int childTop = getPaddingTop();
        int childRight = getWidth() - getPaddingRight();
        int childBottom = getHeight() - getPaddingBottom();

        int xOff;
        int yOff;
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);

            xOff = Math.max(0, width - child.getMeasuredWidth()) / 2;
            yOff = Math.max(0, height - child.getMeasuredHeight()) / 2;

            child.layout(childLeft + xOff, childTop + yOff, childRight - xOff, childBottom - yOff);
        }
    }
}
