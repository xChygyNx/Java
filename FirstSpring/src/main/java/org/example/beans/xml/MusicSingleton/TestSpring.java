package org.example.beans.xml.MusicSingleton;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContextFileSingleton.xml"
        );

        MusicPlayer player = context.getBean("MusicPlayer", MusicPlayer.class);
        player.playMusic();
        MusicPlayer playerTwo = context.getBean("MusicPlayer", MusicPlayer.class);
        System.out.println(player.getVolume());
        System.out.println(playerTwo.getVolume());
        player.setVolume(15);
        System.out.println(player.getVolume());
        System.out.println(playerTwo.getVolume());

        context.close();
    }
}