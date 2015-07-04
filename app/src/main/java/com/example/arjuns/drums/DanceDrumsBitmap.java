package com.example.arjuns.drums;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by arjuns on 7/3/2015.
 */
public class DanceDrumsBitmap extends ImageView implements View.OnTouchListener {
    public Context myContext;
    public Intent homeScreenIntent;
    private Canvas myCanvas;
    public float x = 0, y = 0;// 854x480
    public float rx;
    public float ry;
    private Handler myHandler;
    private final int FRAME_RATE = 30;
    private int touched = 0;
    int[] soundId;
    public SoundPool mySoundPool;

    AudioManager audioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);
    float actualVolume = (float) audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
    float maxVolume = (float) audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
    float volume = actualVolume / maxVolume;


    public DanceDrumsBitmap(Context context, AttributeSet a) {
        super(context, a);
        myContext = context;
        myHandler = new Handler();
        mySoundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        soundId = new int[26];
        loadSounds();
    }

    public Bitmap resizeImage(Bitmap image) {
        Bitmap resized;
        float imageHeight, imageWidth;
        imageHeight=image.getHeight()*ry;
        imageWidth=image.getWidth()*rx;
        resized=Bitmap.createScaledBitmap(image, (int) imageWidth, (int)imageHeight, true);
        return resized;
    }

    public void loadSounds() {
        soundId[0] = mySoundPool.load(getContext(), R.raw.dance_crash, 1);
        soundId[1] = mySoundPool.load(getContext(), R.raw.dance_clap, 1);
        soundId[2] = mySoundPool.load(getContext(), R.raw.dance_hihat, 1);
        soundId[3] = mySoundPool.load(getContext(), R.raw.dance_ride, 1);
        soundId[4] = mySoundPool.load(getContext(), R.raw.dance_ride2, 1);
        soundId[5] = mySoundPool.load(getContext(), R.raw.dance_snare, 1);
        soundId[6] = mySoundPool.load(getContext(), R.raw.dance_tom1, 1);
        soundId[7] = mySoundPool.load(getContext(), R.raw.dance_tom2, 1);
        soundId[8] = mySoundPool.load(getContext(), R.raw.dance_tom3, 1);
        soundId[9] = mySoundPool.load(getContext(), R.raw.dancekick, 1);
    }

    private Runnable r = new Runnable() {

        public void run() {
            invalidate();
        }
    };

    @Override
    protected void onSizeChanged(int xNew, int yNew, int xOld, int yOld) {
        super.onSizeChanged(xNew, yNew, xOld, yOld);
        rx = (float) xNew / 854;
        ry = (float) yNew / 480;
    }


    public boolean onTouch(View v, MotionEvent event) {
        myHandler.post(new Runnable() {
            public void run() {
                DanceDrumsBitmap.this.setVisibility(View.VISIBLE);
            }
        });
        x = event.getX();
        y = event.getY();
        touched = 1;
        return false;
    }

    protected void onDraw(Canvas c) {
        DanceDrumsBitmap.this.myCanvas = c;
        if (touched == 1) {

            // left with pedal
            if ( x > 10*rx && x <= 149*rx &&  y >= 203*ry &&  y < 346*ry) {
                x = 110 * rx;
                y = 345 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.dance5);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
                mySoundPool.play(soundId[2], volume, volume, 1, 0 , 1f);
            }

            //left white
            else if ( x > 187*rx &&  x < 345*rx &&  y > 323*ry
                    &&  y < 445*ry) {
                x = rx * 265;
                y = 369 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.dance7);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
                mySoundPool.play(soundId[5], volume, volume, 1, 0, 1f);
            }

            //left top gold
            else if ( x > 30*rx &&  x < 272*rx &&  y > 104*ry
                    &&  y < 255*ry) {
                x = 161 * rx;
                y = 168 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.dance2);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
                mySoundPool.play(soundId[0], volume, volume, 1, 0 , 1f);
            }

            //right top gold
            else if ( x > 565*rx &&  x < 758*rx &&  y > 75*ry
                    &&  y < 265*ry) {
                x = 637 * rx;
                y = 165 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.dance3);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
                mySoundPool.play(soundId[3], volume, volume, 1, 0 , 1f);
            }

            //middle pedal
            else if (x  >= 380*rx && x  < 420 *rx&& y  > 314*ry
                    && y  < 425*ry) {
                x = 397 * rx;
                y = 339 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.dance6);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
                mySoundPool.play(soundId[9], volume, volume, 1, 0 , 1f);
            }

            //right bottom gold
            else if ( x >= 613*rx &&  x < 830*rx && y  > 239*ry&&  y < 355*ry) {
                x = 733 * rx;
                y = 279 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.dance4);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
                mySoundPool.play(soundId[1], volume, volume, 1, 0 , 1f);
            }

            //center right drum
            else if ( x >= 387*rx &&  x < 558*rx &&  y > 208*ry
                    &&  y < 318*ry) {
                x = 489 * rx;
                y = 257 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.dance9);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
                mySoundPool.play(soundId[7], volume, volume, 1, 0 , 1f);
            }

            //center left drum
            else if (x  >= 223*rx && x  < 344*rx && y > 239*ry
                    && y  < 345*ry) {
                x = 298 * rx;
                y = 255 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.dance10);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
                mySoundPool.play(soundId[6], volume, volume, 1, 0 , 1f);
            }

            //right lower drum
            else if ( x >= 507*rx &&  x < 728*rx &&  y > 298*ry
                    &&  y < 450*ry) {
                x = 598 * rx;
                y = 389 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.dance8);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
                mySoundPool.play(soundId[8], volume, volume, 1, 0 , 1f);
            }

            //center gold
            else if (x  >= 337*rx && x  < 473*rx && y > 80*ry
                    && y  < 160*ry) {
                x = 393 * rx;
                y = 119 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.dance1);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
                mySoundPool.play(soundId[4], volume, volume, 1, 0 , 1f);
            }

            //back button
            else if(x>750*rx&&x<841*rx&&y>0*ry&&y<58*ry)
            {
                x=rx*795;
                y=ry*27;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.back);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
                homeScreenIntent = new Intent(getContext().getApplicationContext(),HomeScreen.class);
                homeScreenIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getContext().getApplicationContext().startActivity(homeScreenIntent);
            }

            myHandler.postDelayed(new Runnable() {
                public void run() {
                    DanceDrumsBitmap.this.setVisibility(View.INVISIBLE);
                }
            }, 150);
            touched = 0;
        }
        this.setOnTouchListener(this);
        myHandler.postDelayed(r, FRAME_RATE);
    }
}
