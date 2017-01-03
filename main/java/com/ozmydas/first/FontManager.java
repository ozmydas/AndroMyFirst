package com.ozmydas.first;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static android.R.attr.typeface;

/**
 * Created by Admin on 16/12/2016.
 */

public class FontManager {

    public static final String ROOT = "fonts/", FONTAWESOME = ROOT + "fontawesome-webfont.ttf";

    public static Typeface getTypeFace(Context context, String font){
        return Typeface.createFromAsset(context.getAssets(), font);
    } //end method



}
