package org.example.beans.JavaClassManual;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class ClassicalMusic implements Music {
    /*@PostConstruct
    public void myInit() {
        System.out.println("Hello, I'm ClassicalMusic");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroy ClassicalMusic");
    }*/

    @Override
    public String getSong() {
        return "Moon Sonata";
    }
}
