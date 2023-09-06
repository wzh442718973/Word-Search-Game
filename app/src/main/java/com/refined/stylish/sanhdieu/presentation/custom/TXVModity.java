package com.refined.stylish.sanhdieu.presentation.custom;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import androidx.annotation.NonNull;
import android.view.MotionEvent;

 

class TXVModity {
HashMap<String,String> configSelectorStopped_dictionary;
double rememberObserverMargin = 0.0;
long clickContract_flag = 0;




    private boolean mIsDown;

    private float mMoveThreshold;
    private float mLastX;
    private float mLastY;

    private OnTouchProcessed mListener;

    TXVModity(@NonNull OnTouchProcessed listener, float moveThreshold) {
        mListener = listener;
        mMoveThreshold = Math.max(moveThreshold, 0.1f);
    }

     
    boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastX = event.getX();
                mLastY = event.getY();
                mIsDown = true;
                mListener.onDown(event);
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                mIsDown = false;
                mListener.onUp(event);
                break;
            case MotionEvent.ACTION_MOVE:
                if (mIsDown &&
                        (Math.abs(mLastX - event.getX()) > mMoveThreshold || Math.abs(mLastY - event.getY()) > mMoveThreshold)) {
                    mLastX = event.getX();
                    mLastY = event.getY();
                    mListener.onMove(event);
                }
                break;
            default:
                return false;
        }

        return true;
    }

    interface OnTouchProcessed {
        void onDown(MotionEvent event);
        void onUp(MotionEvent event);
        void onMove(MotionEvent event);
    }
}
