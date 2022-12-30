package com.davtyan.m3l5_kolobok;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;

public class BitmapBank {
    Bitmap background;
    Bitmap[] kolobok;


    public BitmapBank(Resources resources) {
        background = BitmapFactory.decodeResource(resources, R.drawable.les2);
        background = scaleImage(background);
        kolobok = new Bitmap[4];
        kolobok[0] = BitmapFactory.decodeResource(resources, R.drawable.kolobok0);
        kolobok[1] = BitmapFactory.decodeResource(resources, R.drawable.kolobok1);
        kolobok[2] = BitmapFactory.decodeResource(resources, R.drawable.kolobok2);
        kolobok[3] = BitmapFactory.decodeResource(resources, R.drawable.kolobok3);
    }

    public Bitmap getKolobok(int frame) {
        return kolobok[frame];
    }

    public int getKolobokWidth() {
        return kolobok[0].getWidth();
    }

    public int getKolobokHeight() {
        return kolobok[0].getWidth();
    }

    public Bitmap getBackground() {
        return background;
    }

    public int getBackgroundWidth() {
        return background.getWidth();
    }

    public int getBackgroundHeight() {
        return background.getHeight();
    }

    public Bitmap scaleImage(Bitmap bitmap) {
        float widthHeightRatio = getBackgroundWidth() / getBackgroundHeight();
        int backgroundScaledWidth = (int) widthHeightRatio * AppConstants.SCREEN_HEIGHT;
        return Bitmap.createScaledBitmap(bitmap, backgroundScaledWidth, AppConstants.SCREEN_HEIGHT, false);
    }

}
