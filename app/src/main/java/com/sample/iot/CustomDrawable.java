package com.sample.iot;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

public class CustomDrawable extends Drawable {

    private final int color1;
    private final Paint paint;
    private float level;

    public CustomDrawable(int color1, int color2) {
        this.color1 = color1;
        paint = new Paint();
        paint.setColor(color2);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    @Override protected boolean onLevelChange(int level) {
        invalidateSelf();
        return true;
    }

    @Override public void draw(@NonNull Canvas canvas) {
        canvas.drawColor(color1);
        level = (10000-getLevel()) / 10000f;
        canvas.drawRect(
                0,
                getBounds().height() * level, // tweak this line if not drawing properly
                getBounds().width(),
                getBounds().height(), paint);
    }

    @Override public void setAlpha(int alpha) {

    }

    @Override public void setColorFilter(ColorFilter colorFilter) {

    }

    @Override public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}