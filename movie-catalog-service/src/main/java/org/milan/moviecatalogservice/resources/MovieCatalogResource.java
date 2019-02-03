package org.milan.moviecatalogservice.resources;

import org.milan.moviecatalogservice.models.CatalogItem;
import org.milan.moviecatalogservice.models.MovieInfo;
import org.milan.moviecatalogservice.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
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

        List<Rating> ratings = Arrays.asList(
                new Rating("1234", 4),
                new Rating("5679", 3)
        );

        return ratings.stream().map(rating -> {
            MovieInfo movieInfo = restTemplate.getForObject("http://localhost:5002/movies/" + rating.getMovieId(), MovieInfo.class);
            return new CatalogItem(movieInfo.getName(), movieInfo.getDesc(), rating.getRating());
        }).collect(Collectors.toList());
    }
}
