package com.example.ahmed.media;

public class Music {

    private int singerPic;
    private String singerName;
    private String song;
    private String time;
    private int play;
    private int backward;
    private int forward;
    private int audio;

    public Music(int singerPic, String singerName, String song, String time,
                 int play, int backward, int forward, int audio) {

        this.singerPic = singerPic;
        this.singerName = singerName;
        this.song = song;
        this.time = time;
        this.play = play;
        this.backward = backward;
        this.forward = forward;
        this.audio = audio;
    }

    public int getSingerPic() {
        return singerPic;
    }

    public String getSingerName() {
        return singerName;
    }

    public String getSong() {
        return song;
    }

    public String getTime() {
        return time;
    }

    public int getPlay() {
        return play;
    }

    public int getBackward() {
        return backward;
    }

    public int getForward() {
        return forward;
    }

    public int getAudio() {
        return audio;
    }
}
