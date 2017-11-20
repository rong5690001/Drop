package com.rong.drop.base;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.rong.drop.utils.TextUtils;

/**
 * Created by chen.huarong on 2017/11/20.
 */

public class BaseActivity extends AppCompatActivity {

    public void setTypeface(String typeface, TextView textView){
        TextUtils.setTypeFace(typeface, textView);
    }
}
