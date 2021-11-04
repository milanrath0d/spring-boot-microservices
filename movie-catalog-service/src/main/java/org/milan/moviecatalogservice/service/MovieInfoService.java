package org.milan.moviecatalogservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.milan.moviecatalogservice.models.CatalogItem;
import org.milan.moviecatalogservice.models.MovieInfo;
import org.milan.moviecatalogservice.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Class responsible for fetching movie info
 *
 * @author Milan Rathod
 */
@Service
public class MovieInfoService {

    private static final String MOVIE_INFO_REST_URL = "http://movie-info-service/movies/";

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackCatalogItem")
    public CatalogItem getCatalogItem(Rating rating) {
        MovieInfo movieInfo = restTemplate.getForObject(MOVIE_INFO_REST_URL +
                rating.getMovieId(), MovieInfo.class);
        return new CatalogItem(movieInfo.getName(), movieInfo.getDesc(), rating.getRating());
    }

    private CatalogItem getFallbackCatalogItem(Rating rating) {
        return new CatalogItem("Movie name Not found", "", rating.getRating());
    }
}
