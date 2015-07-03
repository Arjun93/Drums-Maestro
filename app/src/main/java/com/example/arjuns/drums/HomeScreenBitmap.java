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
    public Intent i1,i2,i3,i4;
    private Canvas myCanvas;
    public Thread t;
    public float x = 0, y = 0;// 854x480
    public float rx;
    public float ry;
    private Handler myHandler;
    private final int FRAME_RATE = 30;
    private int touched = 0;
    BitmapDrawable b1,b2,b3,b4;

    public HomeScreenBitmap(Context context, AttributeSet a) {
        super(context, a);
        mycontext = context;
        myHandler = new Handler();
        b1 = (BitmapDrawable) getContext().getResources().getDrawable(R.drawable.funkbutton);
        b2 = (BitmapDrawable) getContext().getResources().getDrawable(R.drawable.dancebutton);
        b3 = (BitmapDrawable) getContext().getResources().getDrawable(R.drawable.electrobutton);
        b4 = (BitmapDrawable) getContext().getResources().getDrawable(R.drawable.realbutton);
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
                x = rx * 121;
                y = 170 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.funkbutton);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
                /*i1 = new Intent(getContext(),MainActivity4.class);
                getContext().startActivity(i1);*/
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
                /*i2 = new Intent(getContext(),MainActivity3.class);
                getContext().startActivity(i2);*/
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
                /*i3=new Intent(getContext(),MainActivity.class);
                getContext().startActivity(i3);*/
            }
            //if real drum is selected
            else if (x >= 650*rx && x < 806*rx && y > 87*ry && y < 250*ry) {
                x = 730 * rx;
                y = 169 * ry;
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.realbutton);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
                /*i4=new Intent(getContext(),MainActivity2.class);
                getContext().startActivity(i4);*/
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
        // abc.drawColor(Color.TRANSPARENT);

    }
}

