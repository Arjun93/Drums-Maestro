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

    public DanceDrumsBitmap(Context context, AttributeSet a) {
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
            if ( x > 10*rx && x <= 149*rx &&  y >= 203*ry &&  y < 346*ry) {
                x = 110 * rx;
                y = 347 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.dance5);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
            }// left with pedal

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
            }//left white

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
            }//left gold

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
            }//right top gold

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
            }//middle pedal

            else if ( x >= 613*rx &&  x < 830*rx && y  > 239*ry&&  y < 355*ry) {
                x = 733 * rx;
                y = 279 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.dance4);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
            }//right gold cut

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
            }//center right drum

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
            }//center left drum

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
            }//right lower drum

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
            }//center gold
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
