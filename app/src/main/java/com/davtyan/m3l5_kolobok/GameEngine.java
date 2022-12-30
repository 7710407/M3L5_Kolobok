package com.davtyan.m3l5_kolobok;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class GameEngine {
    BackgroundImage backgroundImage;
    Kolobok kolobok;
    static int gameState;
    public GameEngine() {
        backgroundImage = new BackgroundImage();
        kolobok = new Kolobok();
        gameState = 0;
    }

    public void updateAndDrawBackgroundImage(Canvas canvas) {
        backgroundImage.setX(backgroundImage.getX() - backgroundImage.getVelocity());
        if(backgroundImage.getX() < -AppConstants.getBitmapBank().getBackgroundWidth()) {
            backgroundImage.setX(0);
        }
        canvas.drawBitmap(AppConstants.getBitmapBank().getBackground(), backgroundImage.getX(),
                backgroundImage.getY(), null);
        if(backgroundImage.getX() < -(AppConstants.getBitmapBank().getBackgroundWidth() -
                AppConstants.SCREEN_WIDTH)) {
            canvas.drawBitmap(AppConstants.getBitmapBank().getBackground(), backgroundImage.getX() +
                    AppConstants.getBitmapBank().getBackgroundWidth(),
                    backgroundImage.getY(), null);
        }
    }

    public void updateAndDrawKolobok(Canvas canvas) {
        if(gameState == 1) {
            if(kolobok.getY() < (AppConstants.SCREEN_HEIGHT - AppConstants.getBitmapBank().getKolobokHeight())
                || kolobok.getVelocity() < 0) {
                kolobok.setVelocity(kolobok.getVelocity() + AppConstants.gravity);
                kolobok.setY(kolobok.getY() + kolobok.getVelocity());
            }
        }


        int currentFrame= kolobok.getCurrentFrame();
        Bitmap bitmap = AppConstants.getBitmapBank().getKolobok(currentFrame);
        canvas.drawColor(Color.TRANSPARENT);
        canvas.drawBitmap(bitmap, kolobok.getX(), kolobok.getY(), null);

        currentFrame++;
        if(currentFrame > kolobok.maxFrame) {
            currentFrame = 0;
        }
        kolobok.setCurrentFrame(currentFrame);
    }
}
