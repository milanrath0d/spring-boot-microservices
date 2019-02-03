package org.milan.ratingsdataservice.resources;

import org.milan.ratingsdataservice.models.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
