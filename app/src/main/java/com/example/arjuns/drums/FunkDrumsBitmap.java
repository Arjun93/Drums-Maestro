package com.example.arjuns.drums;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by arjuns on 7/3/2015.
 */
public class FunkDrumsBitmap extends ImageView implements View.OnTouchListener {
    public Context myContext;
    private Canvas myCanvas;
    public float x = 0, y = 0;// 854x480
    public float rx;
    public float ry;
    private Handler myHandler;
    private final int FRAME_RATE = 30;
    private int touched = 0;
    Intent homeScreenIntent;

    public FunkDrumsBitmap(Context context, AttributeSet a) {
        super(context, a);
        myContext = context;
        myHandler = new Handler();
    }

    public Bitmap resizeImage(Bitmap image) {
        Bitmap resized;
        float imageHeight, imageWidth;
        imageHeight=image.getHeight()*ry;
        imageWidth=image.getWidth()*rx;
        resized=Bitmap.createScaledBitmap(image, (int) imageWidth, (int)imageHeight, true);
        return resized;
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
                FunkDrumsBitmap.this.setVisibility(View.VISIBLE);
            }
        });
        x = event.getX();
        y = event.getY();
        touched = 1;
        return false;
    }

    protected void onDraw(Canvas c) {
        FunkDrumsBitmap.this.myCanvas = c;
        if (touched == 1) {

            //left top gold
            if ( x > 70*rx && x <= 270*rx && y >= 123*ry && y < 244*ry) {
                x = 186 * rx;
                y = 164 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.funk1);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
            }
            //left bottom gold with kick
            else if ( x > 20*rx && x < 185*rx && y > 265*ry && y < 404*ry) {
                x = rx * 99;
                y = 360 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.funk2);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
            }
            //left circle drum
            else if (x >= 193*rx && x < 294*rx && y > 239*ry && y < 345*ry) {
                x = 223 * rx;
                y = 310 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.funk3);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
            }
            //second left drum over big kick
            else if (x >= 203*rx && x < 374*rx && y > 189*ry && y < 345*ry) {
                x = 343 * rx;
                y = 260 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.funk4);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
            }
            //white snare below the two left drums
            else if (x >= 263*rx && x < 384*rx && y > 299*ry && y < 447*ry) {
                x = 323 * rx;
                y = 395 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.funk5);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
            }
            //middle kick
            else if (x >= 413*rx && x < 484*rx && y > 299*ry && y < 447*ry) {
                x = 451 * rx;
                y = 385 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.funk6);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
            }
            //right drum
            else if (x >= 513*rx && x < 624*rx && y > 299*ry && y < 447*ry) {
                x = 568 * rx;
                y = 387 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.funk10);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);

            }
            //right lower gold
            else if (x >= 583*rx && x < 828*rx && y > 299*ry && y < 447*ry) {
                x = 738 * rx;
                y = 377 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.funk9);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
            }
            //right top right gold
            else if (x >= 683*rx && x < 828*rx && y > 120*ry && y < 280*ry) {
                x = 755 * rx;
                y = 213 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.funk7);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
            }
            //left top gold
            else if (x >= 503*rx && x < 728*rx && y > 120*ry && y < 280*ry) {
                x = 587 * rx;
                y = 227 * ry;
                this.setVisibility(View.VISIBLE);
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.funk8);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
            }
            //back button
            else if(x > 750*rx && x <841*rx && y > 0*ry && y < 58*ry)
            {
                x = rx * 795;
                y = ry * 27;
                this.setVisibility(View.VISIBLE);
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
                    FunkDrumsBitmap.this.setVisibility(View.INVISIBLE);
                }
            }, 150);
            touched = 0;
        }
        this.setOnTouchListener(this);
        myHandler.postDelayed(r, FRAME_RATE);
    }
}
