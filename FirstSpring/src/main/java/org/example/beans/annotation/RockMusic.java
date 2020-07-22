package org.example.beans.annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("prototype")
public class RockMusic implements Music {
    @PostConstruct
    public void myInit() {
        System.out.println("Hello, I'm RockMusic");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroy RockMusic");
    }

    @Override
    public String getSong() {
        return "Highway to Hell";
    }
}
