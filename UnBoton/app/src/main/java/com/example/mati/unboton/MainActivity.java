package com.example.mati.unboton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    protected Button boton;
    protected Button boton2;
    protected TextView miTexto;
    int cont = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton=(Button)findViewById(R.id.boton1);
        miTexto=(TextView)findViewById(R.id.texto1);

        boton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                cont ++;
                miTexto.setText("Dani ha farmeado " + cont +" minions");
            }
       // boton2.OnClickListener()






    });
}
}

