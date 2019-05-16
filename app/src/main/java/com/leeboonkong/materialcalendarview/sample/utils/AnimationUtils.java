package com.leeboonkong.materialcalendarview.sample.utils;


import android.content.Context;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

import static com.leeboonkong.materialcalendarview.internal.utils.ScreenUtils.getScreenHeight;

public final class AnimationUtils {

    private AnimationUtils() {
    }

    public static void animate(@NonNull View v, @NonNull Context ctx) {
        ViewCompat.setTranslationY(v, getScreenHeight(ctx));
        ViewCompat.setAlpha(v, 0f);
        ViewCompat.animate(v)
                .translationY(0f)
                .setDuration(1500)
                .alpha(1f)
                .setInterpolator(new DecelerateInterpolator(3.0f))
                .start();
    }
}
