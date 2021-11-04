package org.milan.moviecatalogservice.resources;

import org.milan.moviecatalogservice.models.CatalogItem;
import org.milan.moviecatalogservice.models.UserRating;
import org.milan.moviecatalogservice.service.MovieInfoService;
import org.milan.moviecatalogservice.service.UserRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private MovieInfoService movieInfoService;

    @Autowired
    private UserRatingService userRatingService;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable String userId) {

        UserRating ratings = userRatingService.getUserRating(userId);

        return ratings.getRatings().stream().map(rating ->
                movieInfoService.getCatalogItem(rating)).collect(Collectors.toList());
    }
}
