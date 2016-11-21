package com.example.mati.examen_pmm;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class Dibujo extends View
{
    public Dibujo(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Dibujo(Context context) {
        super(context);
    }

    protected void onDraw(Canvas canvas){

        setBackgroundColor(Color.GRAY);
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setTextSize(25);
        paint.setStrokeWidth(1);
        canvas.drawText("Ancho:"+getWidth()+" Alto:"+getHeight(),20,40,paint);
        // LA MITAD SERIAN ancho = 352 alto = 375.5

        paint.setStrokeWidth(5);
        //CIRCULO
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(352,250,50,paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(352,250,50,paint);


        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(600,250,50,paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(600,250,50,paint);
        // 2 CIRCULOS PEQUEÑOS




        //RECTANGULO ROMBO
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        canvas.drawRect(50,250,50,100,paint);
        Path pathRectangulo = new Path();



        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPath(pathRectangulo,paint);

        pathRectangulo.moveTo(100,300);
        pathRectangulo.lineTo(900,300);

        pathRectangulo.moveTo(250,250);
        pathRectangulo.lineTo(250,100);

        pathRectangulo.moveTo(760,250);
        pathRectangulo.lineTo(760,100);

        pathRectangulo.moveTo(250,250);
        pathRectangulo.lineTo(760,250);

        pathRectangulo.moveTo(250,100);
        pathRectangulo.lineTo(760,100);





        pathRectangulo.moveTo(760,250);
        pathRectangulo.lineTo(760,100);


        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(pathRectangulo,paint);




    }
}
