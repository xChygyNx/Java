package org.example.beans.JavaClassManual;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfiguration.class
        );

        MusicPlayer player = context.getBean("MusicPlayer", MusicPlayer.class);

        player.playMusic();
        System.out.println("Player: " + player.getName());
        System.out.println("Volume: " + player.getVolume());
        /*ClassicalMusic classicalMusic1 = context.getBean("classicalMusic", ClassicalMusic.class);
        ClassicalMusic classicalMusic2 = context.getBean("classicalMusic", ClassicalMusic.class);
        RockMusic rockMusic1 = context.getBean("rockMusic", RockMusic.class);
        RockMusic rockMusic2 = context.getBean("rockMusic", RockMusic.class);*/
        context.close();
    }
}