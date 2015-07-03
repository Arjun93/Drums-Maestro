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
public class RealDrumsBitmap extends ImageView implements View.OnTouchListener {
    public Context myContext;
    public Intent homeScreenIntent;
    private Canvas myCanvas;
    public float x = 0, y = 0;// 854x480
    public float rx;
    public float ry;
    private Handler myHandler;
    private final int FRAME_RATE = 30;
    private int touched = 0;

    public RealDrumsBitmap(Context context, AttributeSet a) {
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
                RealDrumsBitmap.this.setVisibility(View.VISIBLE);
            }
        });
        x = event.getX();
        y = event.getY();
        touched = 1;
        return false;
    }

    protected void onDraw(Canvas c) {
        RealDrumsBitmap.this.myCanvas = c;
        if (touched == 1) {

            //left smallest crash
            if ( x > 150*rx && x <= 250*rx &&  y >= 163*ry &&  y < 233*ry) {
                x = 199 * rx;
                y = 200 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.real1);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
            }

            //second left crash with kick
            if ( x > 3*rx && x < 175*rx && y > 215*ry && y < 335*ry) {
                x = rx *91 ;
                y = 276 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.real2);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
            }

            //Rightmost bottom crash
            if ( x >= 646*rx &&  x < 846*rx &&  y > 213*ry &&  y < 358*ry) {
                x = 749 * rx;
                y = 286 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.real5);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
            }

            // Right top crash
            if ( x >= 601*rx &&  x < 793*rx && y  > 79*ry&&  y < 217*ry) {
                x = 699 * rx;
                y = 150 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.real4);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
            }

            //left topmost crash
            if (x >= 220*rx && x < 412 *rx && y > 62*ry && y < 196*ry) {
                x = 314 * rx;
                y = 130 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.real6);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
            }

            //right side first crash from middle of the screen
            if (x >= 461*rx && x < 672*rx && y > 130*ry && y < 277*ry) {
                x = 567 * rx;
                y = 208 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.real7);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
            }

            //Left white snare
            if (x >= 256*rx && x < 408*rx && y > 303*ry && y < 407*ry) {
                x = 330 * rx;
                y = 357 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.real9);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
            }

            //
            if (x >= 414*rx && x < 464*rx && y > 285*ry && y < 378*ry) {
                x = 440 * rx;
                y = 330 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.real8);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
            }

            // left most crash with kick
            if ( x > 64*rx && x < 206*rx && y > 315*ry && y < 472*ry) {
                x = 152 * rx;
                y = 391 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.real3);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
            }

            //left most small drum
            else if (x >= 182*rx && x < 302*rx && y  > 231*ry && y < 315*ry) {
                x = 241 * rx;
                y = 274 * ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.real10);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
            }

            //second left most drum - to the right of small drum
            else if(x >= 304*rx && x < 439*rx && y > 194*ry && y < 290*ry)
            {
                x = 371*rx;
                y = 243*ry;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.real11);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
            }

            //First drum on the right side - from middle
            else if(x > 474*rx && x < 637*rx && y > 284*ry && y < 395*ry){
                x = rx*557;
                y = ry*340;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.real12);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
            }

            //Second drum on the right side
            else if(x > 619*rx && x < 801*rx && y > 354*ry && y < 473*ry){
                x = rx*715;
                y = ry*412;
                this.setVisibility(View.VISIBLE);
                final Bitmap currentBitmap;
                currentBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.real13);
                Bitmap scaledBitmap=resizeImage(currentBitmap);
                myCanvas.drawBitmap(scaledBitmap, x - scaledBitmap.getWidth()
                        / 2, y - scaledBitmap.getHeight() / 2, null);
            }

            //back button
            else if(x > 750*rx && x < 841*rx && y > 0*ry && y < 58*ry)
            {
                x=rx*795;
                y=ry*28;
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
                    RealDrumsBitmap.this.setVisibility(View.INVISIBLE);
                }
            }, 150);
            touched = 0;
        }
        this.setOnTouchListener(this);
        myHandler.postDelayed(r, FRAME_RATE);
    }
}

