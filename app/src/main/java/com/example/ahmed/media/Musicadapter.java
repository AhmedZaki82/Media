package com.example.ahmed.media;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Musicadapter extends ArrayAdapter <Music> {
    public Musicadapter(@NonNull Context context,@NonNull List<Music> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        Music currentItem = (Music) getItem(position);

        if (listItemView == null) {

            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.sample,
                    parent,false);
        }

        ImageView singerPic = (ImageView) listItemView.findViewById(R.id.singer_pic_s);
        TextView song = (TextView) listItemView.findViewById(R.id.song_s);
        TextView singerName = (TextView) listItemView.findViewById(R.id.singer_name_s);
        TextView time = (TextView) listItemView.findViewById(R.id.time_s);
        ImageView play = (ImageView) listItemView.findViewById(R.id.play_s);

        singerPic.setImageResource(currentItem.getSingerPic());
        song.setText(currentItem.getSong());
        singerName.setText(currentItem.getSingerName());
        time.setText(currentItem.getTime());
        play.setImageResource(currentItem.getPlay());

        return listItemView;
    }
}
