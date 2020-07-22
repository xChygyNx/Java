package org.example.beans.JavaClassManual;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfiguration {
    @Bean
    public ClassicalMusic classicalMusic() {
        return new ClassicalMusic();
    }

    @Bean
    public RockMusic rockMusic() {
        return new RockMusic();
    }

    @Bean
    public PopMusic popMusic() {
        return new PopMusic();
    }

    @Bean
    public List<Music> genres(){
        List<Music> genres = new ArrayList<>(Arrays.asList(classicalMusic(), rockMusic(), popMusic()));
        return genres;
    }

    @Bean
    public MusicPlayer MusicPlayer() {
        return new MusicPlayer(genres());
    }
}
