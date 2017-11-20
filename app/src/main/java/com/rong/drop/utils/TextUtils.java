package com.rong.drop.utils;

import android.graphics.Typeface;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/11/20/020.
 */

public class TextUtils {

    public static final String MONTSERRAT_BOLD = "fonts/Montserrat_Bold.ttf";
    public static final String MONTSERRAT_REGULAR = "fonts/Montserrat_Regular.ttf";
    public static final String OPENSANS_REGULAR = "fonts/OpenSans_Regular.ttf";
    public static final String SPOON_BOLD = "fonts/Spoon_Bold.otf";

    public static void setTypeFace(String typeFace, TextView textView){
        if(textView == null){
            throw new NullPointerException("textView is null");
        }
        if(textView.getContext() == null){
            throw new NullPointerException("textView.getContext is null");
        }
        textView.setTypeface(Typeface.createFromAsset(textView.getContext().getAssets(), typeFace));
    }
}
