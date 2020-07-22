package org.example.beans.JavaClassAnnotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("org.example.beans.JavaClassAnnotation")
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfiguration {
}
