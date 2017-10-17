package com.example2.acer.androidweardemo2;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.wearable.view.WearableListView;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WearableListItemLayout extends LinearLayout implements WearableListView.OnCenterProximityListener{

    private ImageView mCircle;
    private TextView mName;
    private final float mFadedTextAlpha;
    private final int mFadedCircleColor,mChosenCirlcleColor;

    public WearableListItemLayout(Context context) {
        this(context,null);
    }

    public WearableListItemLayout(Context context, AttributeSet attrs){
        this(context,attrs,0);
    }
    public WearableListItemLayout(Context context, AttributeSet attrs,int defStyle){
        super(context,attrs,defStyle);
        mFadedTextAlpha = 0.7f;
        mFadedCircleColor=getResources().getColor(R.color.grey);
        mChosenCirlcleColor=getResources().getColor(R.color.blue);

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mCircle=(ImageView) findViewById(R.id.circle);
        mName=(TextView)findViewById(R.id.name);
    }

    @Override
    public void onCenterPosition(boolean b) {
         mName.setAlpha(1f);
        ((GradientDrawable) mCircle.getDrawable()).setColor(mChosenCirlcleColor);
    }

    @Override
    public void onNonCenterPosition(boolean b) {
        ((GradientDrawable) mCircle.getDrawable()).setColor(mFadedCircleColor);
         mName.setAlpha(mFadedTextAlpha);
    }
}
