package org.milan.moviecatalogservice.resources;

import org.milan.moviecatalogservice.models.CatalogItem;
import org.milan.moviecatalogservice.models.MovieInfo;
import org.milan.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller For Movie Catalog
 *
 * @author Milan Rathod
 */
@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable String userId) {

        UserRating ratings = restTemplate.getForObject("http://ratings-data-service/ratings/users/" + userId, UserRating.class);

        return ratings.getRatings().stream().map(rating -> {
            MovieInfo movieInfo = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), MovieInfo.class);
            return new CatalogItem(movieInfo.getName(), movieInfo.getDesc(), rating.getRating());
        }).collect(Collectors.toList());
    }
}
