package com.example.mati.primerdibujo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MiDibujo(this));

    }
    class MiDibujo extends View{
        public MiDibujo(Context c){
             super(c);
        }
        protected void onDraw(Canvas lienzo){
            Paint miPincel = new Paint();
            miPincel.setColor(Color.RED);

            miPincel.setStyle(Paint.Style.STROKE);

            for (int i=0; i<1000; i+=55)

            lienzo.drawCircle(500,20,50+i, miPincel);


            miPincel.setTextSize(60);
            lienzo.drawText("Mi circulo", 500,900, miPincel);
        }
    }
}
