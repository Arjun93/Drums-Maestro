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
public class HomeScreenBitmap extends ImageView implements View.OnTouchListener {
    public Context mycontext;
    public Intent danceDrumIntent,funkDrumIntent,electroDrumIntent, realDrumIntent;
    private Canvas myCanvas;
    public Thread t;
    public float x = 0, y = 0;// 854x480
    public float rx;
    public float ry;
    private Handler myHandler;
    private final int FRAME_RATE = 30;
    private int touched = 0;


    public HomeScreenBitmap(Context context, AttributeSet a) {
        super(context, a);
        mycontext = context;
        myHandler = new Handler();
    }

    private Runnable r = new Runnable() {

        public void run() {
            invalidate();
        }
    };

    public Bitmap resizeImage(Bitmap image) {
        Bitmap resized;
        float imageHeight, imageWidth;
        imageHeight=image.getHeight()*ry;
        imageWidth=image.getWidth()*rx;
        resized=Bitmap.createScaledBitmap(image, (int) imageWidth, (int)imageHeight, true);
        return resized;
    }

    @Override
    protected void onSizeChanged(int xNew, int yNew, int xOld, int yOld) {
        super.onSizeChanged(xNew, yNew, xOld, yOld);
        rx = (float) xNew / 854;
        ry = (float) yNew / 480;
    }


    public boolean onTouch(View v, MotionEvent event) {
        myHandler.post(new Runnable() {
            public void run() {
                HomeScreenBitmap.this.setVisibility(View.VISIBLE);
            }
        });
        x = event.getX();
        y = event.getY();
        touched = 1;
        return false;
    }

    protected void onDraw(Canvas c) {
        HomeScreenBitmap.this.myCanvas = c;
        if (touched == 1) {

            //if funk drum is selected
            if ( x > 45*rx &&  x < 201*rx &&  y > 90*ry &&  y < 247*ry) {
                x = rx * 123;
                y = 170 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.funkbutton);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
                funkDrumIntent= new Intent(getContext(),FunkDrums.class);
                getContext().startActivity(funkDrumIntent);
            }

            //if dance drum is selected
            else if (x  >= 240*rx && x  < 394*rx && y > 49*ry && y  < 208*ry) {
                x = 317 * rx;
                y =  127 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.dancebutton);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
                danceDrumIntent = new Intent(getContext(),DanceDrums.class);
                getContext().startActivity(danceDrumIntent);
            }

            //if electro drum is selected
            else if (x >= 454*rx && x < 611*rx && y > 49*ry && y < 208*ry) {
                x = 532 * rx;
                y = 127 * ry;
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.electrobutton);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
                electroDrumIntent=new Intent(getContext(),ElectroDrums.class);
                getContext().startActivity(electroDrumIntent);
            }

            //if real drum is selected
            else if (x >= 650*rx && x < 806*rx && y > 87*ry && y < 250*ry) {
                x = 728 * rx;
                y = 169 * ry;
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.realbutton);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
                realDrumIntent = new Intent(getContext(),RealDrums.class);
                getContext().startActivity(realDrumIntent);
            }

            myHandler.postDelayed(new Runnable() {

                public void run() {
                    HomeScreenBitmap.this.setVisibility(View.INVISIBLE);
                }
            }, 150);
            touched = 0;
        }

        this.setOnTouchListener(this);
        myHandler.postDelayed(r, FRAME_RATE);
    }
}

