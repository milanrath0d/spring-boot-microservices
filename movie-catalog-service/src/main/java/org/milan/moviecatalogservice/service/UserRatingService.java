package org.milan.moviecatalogservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.milan.moviecatalogservice.models.Rating;
import org.milan.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

/**
 * Class responsible for fetching user ratings
 *
 * @author Milan Rathod
 */
@Service
public class UserRatingService {

    private static final String RATING_SERVICE_REST_URL = "http://ratings-data-service/ratings/users/";

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackUserRating")
    public UserRating getUserRating(String userId) {
        return restTemplate.getForObject(RATING_SERVICE_REST_URL + userId, UserRating.class);
    }

    private UserRating getFallbackUserRating(String userId) {
        UserRating userRating = new UserRating();
        userRating.setUserId(userId);
        userRating.setRatings(Collections.singletonList(new Rating("0", 0)));
        return userRating;
    }
}
