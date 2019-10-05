package org.milan.ratingsdataservice.models;

import java.util.List;

/**
 * Pojo for User Rating
 *
 * @author Milan Rathod
 */
public class UserRating {

    private String userId;

    private List<Rating> ratings;

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
