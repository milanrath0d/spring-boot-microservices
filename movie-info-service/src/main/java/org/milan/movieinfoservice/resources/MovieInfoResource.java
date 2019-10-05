package org.milan.movieinfoservice.resources;

import org.milan.movieinfoservice.models.MovieInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for Movie Info
 *
 * @author Milan Rathod
 */
@RestController
@RequestMapping("/movies")
public class MovieInfoResource {

    @GetMapping("/{movieId}")
    public MovieInfo getMovieInfo(@PathVariable String movieId) {
        return new MovieInfo(movieId, "Hulk", "test");
    }
}
