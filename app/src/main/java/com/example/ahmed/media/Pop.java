package com.example.ahmed.media;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Pop extends Fragment {


    public Pop() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.play_lis, container, false);

        ArrayList<Music> music = new ArrayList<>();


        music.add(new Music(R.drawable.george_michael,"George Micheal",
                "Older","05:30",R.drawable.play,R.drawable.backward,
                R.drawable.forward,R.raw.celine));


        music.add(new Music(R.drawable.shania_twain,"Shania Twain",
                "Kash","03:25",R.drawable.play,R.drawable.backward,
                R.drawable.forward,R.raw.mirror));

        music.add(new Music(R.drawable.michael_jackson,"Micheal Jackson",
                "Earht Song","05:55",R.drawable.play,R.drawable.backward,
                R.drawable.forward,R.raw.celine));

        music.add(new Music(R.drawable.mariah_carey,"Mariah Carey",
                "Hero","3:25",R.drawable.play,R.drawable.backward,
                R.drawable.forward,R.raw.celine));

        ListView listView = rootView.findViewById(R.id.list_view);

        Musicadapter musicadapter = new Musicadapter(getActivity(),music);

        listView.setAdapter(musicadapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Music selectedItim = (Music) parent.getItemAtPosition(position);

                int singerPic = selectedItim.getSingerPic();
                String song = selectedItim.getSong();
                int backward = selectedItim.getBackward();
                int play = selectedItim.getPlay();
                int forward = selectedItim.getForward();
                int playSelectedSong = selectedItim.getAudio();

                Intent put = new Intent(getActivity(),PlayNow.class);
                put.putExtra("pic",singerPic);
                put.putExtra("song",song);
                put.putExtra("backward",backward);
                put.putExtra("play",play);
                put.putExtra("forward",forward);
                put.putExtra("play selected song",playSelectedSong);

                startActivity(put);
            }
        });
        // Inflate the layout for this fragment
        return rootView;
    }

}
