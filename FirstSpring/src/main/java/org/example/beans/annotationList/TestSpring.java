package org.example.beans.annotationList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContextAnnotationList.xml"
        );

        MusicPlayer player = context.getBean("MusicPlayer", MusicPlayer.class);
        List<Music> musicList = new ArrayList<>();
        musicList.add(context.getBean("rockMusic", Music.class));
        musicList.add(context.getBean("classicalMusic", Music.class));

        player.setMusicList(musicList);

        player.playMusic(Genre.ROCK);
        context.close();
    }
}