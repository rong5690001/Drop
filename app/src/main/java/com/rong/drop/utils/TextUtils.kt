package com.rong.drop.utils

import android.graphics.Typeface
import android.widget.TextView

/**
 * Created by Administrator on 2017/11/20/020.
 */

object TextUtils {

    val MONTSERRAT_BOLD = "fonts/Montserrat_Bold.ttf"
    val MONTSERRAT_REGULAR = "fonts/Montserrat_Regular.ttf"
    val OPENSANS_REGULAR = "fonts/OpenSans_Regular.ttf"
    val SPOON_BOLD = "fonts/Spoon_Bold.otf"

    fun setTypeFace(typeFace: String, textView: TextView?) {
        if (textView == null) {
            throw NullPointerException("textView is null")
        }
        if (textView.context == null) {
            throw NullPointerException("textView.getContext is null")
        }
        textView.typeface = Typeface.createFromAsset(textView.context.assets, typeFace)
    }
}
