package com.example.mati.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mati on 31/01/17.
 */
public class ListaPeliculasFragment extends Fragment{
    private ListView listViewPeliculas;
    public static ListaPeliculasFragment newInstance() {

        Bundle args = new Bundle();

        ListaPeliculasFragment fragment = new ListaPeliculasFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_peliculas_view,container,false);

        listViewPeliculas = (ListView) view.findViewById(R.id.listViewPeliculas);

        final List<Item> items = new ArrayList<Item>();
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
        ItemAdapter adapter = new ItemAdapter(getContext(),items);

        listViewPeliculas.setAdapter(adapter);
        //listViewPeliculas.setOnItemSelectedListener(new );
        listViewPeliculas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                 Toast.makeText(getContext(),items.get(position).getTitle(),Toast.LENGTH_SHORT).show();

            }
        });
        return view;
    }

}
