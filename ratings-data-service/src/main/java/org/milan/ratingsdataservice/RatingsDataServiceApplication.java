package org.milan.ratingsdataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Entry point for ratings data serviceo
 *
 * @author Milan Rathod
 */
@SpringBootApplication
@EnableEurekaClient
public class RatingsDataServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RatingsDataServiceApplication.class, args);
    }

}