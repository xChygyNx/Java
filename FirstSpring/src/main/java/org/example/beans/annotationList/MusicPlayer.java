package org.example.beans.annotationList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component ("MusicPlayer")
public class MusicPlayer {
    private ArrayList<Music> musicList = new ArrayList<>();
    private String name;
    private int volume;
    @Autowired
    private ClassicalMusic classic;
    @Autowired
    private RockMusic rock;
    @Autowired
    private PopMusic pop;

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

    @Autowired
    public void setMusicList(List<Music> musicList) {
        this.musicList = (ArrayList)musicList;
    }

    public void playMusic(Genre genre) {
        switch (genre) {
            case POP:
                System.out.println(pop.getSong());
                break;
            case ROCK:
                System.out.println(rock.getSong());
                break;
            case CLASSIC:
                System.out.println(classic.getSong());
        }
    }
}
