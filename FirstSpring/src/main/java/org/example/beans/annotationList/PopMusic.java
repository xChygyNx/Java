package org.example.beans.annotationList;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

@Component
public class PopMusic implements Music {
    private Random rand = new Random();
    private ArrayList<String> songs = new ArrayList<>(Arrays.asList("Zaberi menya s soboi", "Thriller", "Sunny days"));
    @Override
    public String getSong() {
        return songs.get(rand.nextInt(3));
    }
}
