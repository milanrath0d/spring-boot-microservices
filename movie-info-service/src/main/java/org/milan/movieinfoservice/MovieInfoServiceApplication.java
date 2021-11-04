package org.milan.movieinfoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Entry point for movie info service
 *
 * @author Milan Rathod
 */
@SpringBootApplication
@EnableEurekaClient
public class MovieInfoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieInfoServiceApplication.class, args);
    }

}