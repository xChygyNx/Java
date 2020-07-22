package org.example.beans.JavaClassManual;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

public class MusicPlayer {
    @Value("${MusicPlayer.name}")
    private String name;
    @Value("${MusicPlayer.volume}")
    private int volume;
    private List<Music> genres;


    public MusicPlayer () {}

    public MusicPlayer (List<Music> genres) {
        this.genres = genres;
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public void setMusic(Music music) {
        this.music = music;
    }*/

    public void playMusic() {
        Random r = new Random();
        System.out.println(genres.get(r.nextInt(3)).getSong());
    }
}
