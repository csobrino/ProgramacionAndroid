package com.example.mati.myapplication;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class PeliculasView extends Activity {

    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        this.setContentView(R.layout.fragment_peliculas_view);

        this.listView = (ListView) findViewById(R.id.listViewPeliculas);

        List<Item> items = new ArrayList<Item>();
        items.add(new Item(R.drawable.following, "Following",
                "http://www.imdb.com/title/tt0154506/"));
        items.add(new Item(R.drawable.memento, "Memento",
                "http://www.imdb.com/title/tt0209144/"));
        items.add(new Item(R.drawable.batman_begins, "Batman Begins",
                "http://www.imdb.com/title/tt0372784/"));
        items.add(new Item(R.drawable.the_prestige, "The Prestige",
                "http://www.imdb.com/title/tt0482571/"));
        items.add(new Item(R.drawable.the_dark_knight, "The Dark Knight",
                "http://www.imdb.com/title/tt0468569/"));
        items.add(new Item(R.drawable.inception, "Inception",
                "http://www.imdb.com/title/tt1375666/"));
        items.add(new Item(R.drawable.the_dark_knight_rises,
                "The Dark Knight Rises", "http://www.imdb.com/title/tt1345836/"));

        // Sets the data behind this ListView
        this.listView.setAdapter(new ItemAdapter(this, items));

        // Register a callback to be invoked when an item in this AdapterView
        // has been clicked
     /*   listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view,
                                    int position, long arg) {

            }
        });*/

    }


}
