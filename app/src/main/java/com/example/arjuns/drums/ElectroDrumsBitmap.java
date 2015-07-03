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
public class ElectroDrumsBitmap extends ImageView implements View.OnTouchListener {
    public Context myContext;
    public Intent homeScreenIntent;
    private Canvas myCanvas;
    public float x = 0, y = 0;// 854x480
    public float rx;
    public float ry;
    private Handler myHandler;
    private final int FRAME_RATE = 30;
    private int touched = 0;

    public ElectroDrumsBitmap(Context context, AttributeSet a) {
        super(context, a);
        myContext = context;
        myHandler = new Handler();
    }

    public Bitmap resizeImage(Bitmap image) {
        Bitmap resized;
        float imageHeight, imageWidth;
        imageHeight=image.getHeight()*ry;
        imageWidth=image.getWidth()*rx;
        resized=Bitmap.createScaledBitmap(image, (int)imageWidth, (int)imageHeight, true);
        return resized;
    }

    private Runnable r = new Runnable() {
        @Override
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

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        myHandler.post(new Runnable() {
            @Override
            public void run() {
                ElectroDrumsBitmap.this.setVisibility(View.VISIBLE);
            }
        });
        x = event.getX();
        y = event.getY();
        touched = 1;
        return false;
    }

    protected void onDraw(Canvas c) {
        ElectroDrumsBitmap.this.myCanvas = c;
        if (touched == 1) {
            //Toast.makeText(getContext().getApplicationContext(),"x:"+x/rx+" y:"+y/ry,Toast.LENGTH_SHORT).show();

            //left middle gold
            if ( x > 20*rx && x <= 194*rx &&  y >= 173*ry &&  y < 304*ry) {
                x = 113 * rx;
                y = 245 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.electro1);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
            }

            //left gold with kick
            else if ( x > 57*rx &&  x < 205*rx &&  y > 317*ry
                    &&  y < 404*ry) {
                x = rx * 147;
                y = 385 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.electro2);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
            }

            // left gold - KICK PORTION
            else if ( x > 165*rx &&  x < 229*rx &&  y > 404*ry
                    &&  y < 465*ry) {
                x = 145 * rx;
                y = 385 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.electro2);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
            }

            //left top gold
            else if ( x > 165*rx &&  x < 368*rx &&  y > 75*ry
                    &&  y < 235*ry) {
                x = 267 * rx;
                y = 157 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.electro3);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
            }

            // right bottom gold
            else if ( (x >= 645*rx &&  x < 828*rx &&  y > 267*ry &&  y < 370*ry)||
                    (x >= 650*rx &&  x < 828*rx &&  y > 214*ry &&  y < 267*ry)) {
                x = 738 * rx;
                y = 287 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.electro5);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
                //Toast.makeText(getContext().getApplicationContext(),"hi",Toast.LENGTH_SHORT).show();
            }

            //right bottom drum
            else if (x >= 524*rx && x < 704 *rx&& y > 314*ry && y < 415*ry) {
                x = 613 * rx;
                y = 388 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.electro6);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
            }

            //right top gold
            /* else if (( x >= 513*rx &&  x < 732*rx && y  > 79*ry&&  ry < 255*ry) ||
                    (x >= 637*rx &&  x < 715*rx && y  > 86*ry&&  ry < 196*ry)){
                x = 625 * rx;
                y = 169 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.electro4);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
               // Toast.makeText(getContext().getApplicationContext(),"x:"+x/rx+" y:"+y/ry,Toast.LENGTH_SHORT).show();
            }*/

            //center kick
            else if (x  >= 457*rx && x  < 520*rx && y > 320*ry
                    && y  < 430*ry) {
                x = 483 * rx;
                y = 372 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.electro7);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
            }

            //white snare
            else if (x  >= 287*rx && x  < 453*rx && y > 320*ry
                    && y  < 442*ry) {
                x = 369 * rx;
                y = 382 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.electro8);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
            }

            //left small drum
            else if (x  >= 193*rx && x  < 294*rx && y > 239*ry
                    && y  < 345*ry) {
                x = 260 * rx;
                y = 295 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.electro9);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
            }

            //left second small drum
            else if (x  >= 320*rx && x  < 460*rx && y  > 198*ry
                    && y  < 306*ry) {
                x = 393 * rx;
                y = 253 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.electro10);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
            }

            //back
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

                @Override
                public void run() {
                    ElectroDrumsBitmap.this.setVisibility(View.INVISIBLE);
                }
            }, 150);
            touched = 0;
        }
        this.setOnTouchListener(this);
        myHandler.postDelayed(r, FRAME_RATE);
    }
}