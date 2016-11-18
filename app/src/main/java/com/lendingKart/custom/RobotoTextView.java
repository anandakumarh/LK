package com.lendingKart.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.lendingKart.R;
import com.lendingKart.utils.Utils;


public class RobotoTextView extends TextView {
    private static final String TTF_ROBOTO_LIGHT = "roboto-light.ttf";
    private static final String TTF_ROBOTO_THIN = "roboto-thin.ttf";
    private static final String TTF_ROBOTO_MEDIUM = "roboto-regular.ttf";

    private static final String FAMILY_ROBOTO_REGULAR = "sans-serif";
    private static final String FAMILY_ROBOTO_LIGHT = "sans-serif-light";
    private static final String FAMILY_ROBOTO_THIN = "sans-serif-thin";
    private static final String FAMILY_ROBOTO_MEDIUM = "sans-serif-medium";

    private static final boolean HAS_ICE_CREAM_SANDWICH = Utils.hasICS();
    private static final boolean HAS_JELLY_BEAN = Utils.hasJELLYBEAN();
    private static final boolean HAS_JELLY_BEAN_MR1 = Utils.hasJELLYBEAN_MR1();
    private static final boolean HAS_LOLLY_POP = Utils.hasLOLLYPOP();

    private static final int INPUT_FONT_ROBOTO_REGULAR = 0;
    private static final int INPUT_FONT_ROBOTO_LIGHT = 1;
    private static final int INPUT_FONT_ROBOTO_THIN = 2;
    private static final int INPUT_FONT_ROBOTO_MEDIUM = 3;
    private static final int INPUT_FONT_TEXT_DEFAULT = 4;

    private int mTypeFaceType = INPUT_FONT_TEXT_DEFAULT;
    private int mStyle;

    public RobotoTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RobotoTextView, defStyle, 0);
        mTypeFaceType = a.getInt(R.styleable.RobotoTextView_font_type, INPUT_FONT_TEXT_DEFAULT);
       // mStyle = a.getInt(android.R.attr.textStyle, Typeface.NORMAL);
        a.recycle();
        init();
    }

    public RobotoTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RobotoTextView(Context context) {
        this(context, null, 0);
    }

    private void init() {
        if (!HAS_ICE_CREAM_SANDWICH) {
        /* If it does not have 4.0 return.. Lets use normal properties. */
            return;
        }

        /* For 4.0 Roboto Regular and Bold are supported.
         * For 4.1 Roboto light is supported. If it is below 4.1 use ttf file for typeface.
         * For 4.2 Roboto Thin is supported. If it is below 4.2 use ttf file.
         * For 5.0 Roboto Medium is supported. If it is below 5.0 use ttf file.
         */

        Typeface textTypeFace = getTypeface();
        switch (mTypeFaceType) {
            case INPUT_FONT_ROBOTO_REGULAR:
                textTypeFace = Typeface.create(FAMILY_ROBOTO_REGULAR, mStyle);
                break;

            case INPUT_FONT_ROBOTO_LIGHT:
//                if (HAS_JELLY_BEAN) {
                    textTypeFace = Typeface.create(FAMILY_ROBOTO_LIGHT, Typeface.NORMAL);
               /* } else {
                    textTypeFace = Typeface.createFromAsset(getContext().getAssets(), TTF_ROBOTO_LIGHT);
                }*/
                break;
            case INPUT_FONT_ROBOTO_THIN:
//                if (HAS_JELLY_BEAN_MR1) {
                    textTypeFace = Typeface.create(FAMILY_ROBOTO_THIN, Typeface.NORMAL);
               /* } else {
                    textTypeFace = Typeface.createFromAsset(getContext().getAssets(), TTF_ROBOTO_THIN);
                }*/

                break;

            case INPUT_FONT_ROBOTO_MEDIUM:
//                if (HAS_LOLLY_POP) {
                    textTypeFace = Typeface.create(FAMILY_ROBOTO_MEDIUM, Typeface.NORMAL);
              /*  } else {
                    textTypeFace = Typeface.createFromAsset(getContext().getAssets(), TTF_ROBOTO_MEDIUM);
                }
*/
                break;

            default:
                //  textTypeFace = Typeface.create(FAMILY_ROBOTO_REGULAR, Typeface.NORMAL);
                //style = Typeface.NORMAL;
                break;
        }

        if (textTypeFace != null) {
            setTypeface(textTypeFace, mStyle);
        }
    }


    public void setRobotoFaceType(InputTypeFace typeFaceType) {
        switch (typeFaceType) {
            case REGULAR:
                mTypeFaceType = INPUT_FONT_ROBOTO_REGULAR;
                break;
            case LIGHT:
                mTypeFaceType = INPUT_FONT_ROBOTO_LIGHT;
                break;
            case THIN:
                mTypeFaceType = INPUT_FONT_ROBOTO_THIN;
                break;
            case MEDIUM:
                mTypeFaceType = INPUT_FONT_ROBOTO_MEDIUM;
                break;
            case DEFAULT:
                mTypeFaceType = INPUT_FONT_TEXT_DEFAULT;
                break;
            default:
                mTypeFaceType = INPUT_FONT_TEXT_DEFAULT;
                break;
        }

    }

    @Override
    public boolean isInEditMode() {
        return true;
    }

    public enum InputTypeFace {
        REGULAR,
        LIGHT,
        THIN,
        MEDIUM,
        DEFAULT
    }

}