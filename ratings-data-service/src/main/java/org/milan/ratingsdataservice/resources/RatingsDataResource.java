package org.milan.ratingsdataservice.resources;

import org.milan.ratingsdataservice.models.Rating;
import org.milan.ratingsdataservice.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Controller for Movie Rating
 *
 * @author Milan Rathod
 */
@RestController
@RequestMapping("ratings")
public class RatingsDataResource {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable String movieId) {
        return new Rating(movieId, 3);
    }

    @RequestMapping("/users/{userId}")
    public UserRating getRatings(@PathVariable String userId) {
        List<Rating> ratings = Arrays.asList(
                new Rating("1234", 4),
                new Rating("5679", 3)
        );

        UserRating userRating = new UserRating();
        userRating.setRatings(ratings);

        return userRating;
    }
}
