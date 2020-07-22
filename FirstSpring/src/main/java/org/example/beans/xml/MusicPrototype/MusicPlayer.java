package org.example.beans.xml.MusicPrototype;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {
    private ArrayList<Music> musicList = new ArrayList<>();
    private String name;
    private int volume;

    public MusicPlayer () {}

    /*public MusicPlayer (Music music) {
        this.music = music;
    }*/

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = (ArrayList)musicList;
    }

    public void playMusic() {
        for (Music song: musicList) {
            System.out.println(song.getSong());
        }
    }
}
