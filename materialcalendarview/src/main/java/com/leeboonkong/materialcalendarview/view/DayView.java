package com.leeboonkong.materialcalendarview.view;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.leeboonkong.materialcalendarview.internal.data.Day;


public final class DayView extends AppCompatTextView {
    private Day day;

    public DayView(Context context) {
        this(context, null, 0);
    }

    public DayView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DayView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setDay(Day day) {
        setText(String.valueOf(day.getDay()));
        this.day = day;
        invalidate();
    }

    public Day getDay() {
        return day;
    }
}
