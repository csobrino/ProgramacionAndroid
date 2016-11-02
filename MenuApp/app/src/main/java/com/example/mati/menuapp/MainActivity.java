package com.example.mati.menuapp;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.txtView_resultado);
        imageView = (ImageView) findViewById(R.id.imgView);

        registerForContextMenu(imageView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_init,menu);
        return true;
    }


    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_contextual,menu);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menu_contextual_opcion1:
                textView.setText("HAS ELEGIDO LA "+item.getTitle());
                return true;
            case R.id.menu_contextual_opcion2:
                textView.setText("HAS ELEGIDO LA "+item.getTitle());
                return true;
            default:
            {
                return super.onContextItemSelected(item);
            }

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menu_opcion1:
            {
                textView.setText("HAS ELEGIDO LA "+item.getTitle());
                return true;
            }
            case R.id.menu_opcion2:
            {
                textView.setText("HAS ELEGIDO LA "+item.getTitle());
                return true;
            }
            case R.id.menu_opcion3:
            {
                textView.setText("HAS ELEGIDO LA "+item.getTitle());
                return true;
            }
            case R.id.submenu_opcion1_1:
            {
                textView.setText("HAS ELEGIDO LA "+item.getTitle());
                return true;
            }
            case R.id.submenu_opcion1_2:
            {
                textView.setText("HAS ELEGIDO LA "+item.getTitle());
                return true;
            }
            case R.id.submenu_opcion1_3:
            {
                textView.setText("HAS ELEGIDO LA "+item.getTitle());
                return true;
            }
            case R.id.submenu_opcion3_1:
            {
                textView.setText("HAS ELEGIDO LA "+item.getTitle());
                return true;
            }
            case R.id.submenu_opcion3_2:
            {
                textView.setText("HAS ELEGIDO LA "+item.getTitle());
                return true;
            }
            case R.id.submenu_opcion3_3:
            {
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);

                return true;
            }

            default:
            {
                return super.onOptionsItemSelected(item);
            }
        }


    }
}
