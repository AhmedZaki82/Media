package com.example.ahmed.media;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PlayNow extends AppCompatActivity implements View.OnClickListener{

    int playSelectedSong;

    MediaPlayer mMediaPlayer;

    private AudioManager mAudioManager;

    int homeUp = android.R.id.home;

    AudioManager.OnAudioFocusChangeListener listener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume. We'll treat
                // both cases the same way because our app is playing short sound files.

                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                release(mMediaPlayer);
            }
        }
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_now);

        int pic = getIntent().getIntExtra("pic",0);
        String song = getIntent().getStringExtra("song");
        int backward = getIntent().getIntExtra("backward",0);
        int play = getIntent().getIntExtra("play",0);
        int forward = getIntent().getIntExtra("forward",0);
        playSelectedSong = getIntent().getIntExtra("play selected song"
                ,0);

        ImageView picS = (ImageView) findViewById(R.id.singer_pic_p);
        TextView songS = (TextView) findViewById(R.id.song_p);
        ImageView backwardS = (ImageView) findViewById(R.id.backward_p);
        ImageView playS = (ImageView) findViewById(R.id.play_p);
        ImageView forwardS = (ImageView) findViewById(R.id.forward_P);

        picS.setImageResource(pic);
        songS.setText(song);
        backwardS.setImageResource(backward);
        playS.setImageResource(play);
        forwardS.setImageResource(forward);

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

         mMediaPlayer = MediaPlayer.create(PlayNow.this, playSelectedSong);


        playS.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {

        int result = mAudioManager.requestAudioFocus(listener,AudioManager.STREAM_MUSIC,
                AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

        if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
            mMediaPlayer.start();


        }

    }



    @Override
    protected void onPause() {
        super.onPause();
        mMediaPlayer.pause();
    }



    @Override
    protected void onStop() {
        super.onStop();
        mMediaPlayer.pause();
    }




    @Override
    protected void onRestart() {
        super.onRestart();
        mMediaPlayer.start();
    }



    public void release(MediaPlayer mediaPlayer) {

        if (mediaPlayer != null) {

            mediaPlayer.release();
            mediaPlayer = null;

            mAudioManager.abandonAudioFocus(listener);
        }


    }


}
