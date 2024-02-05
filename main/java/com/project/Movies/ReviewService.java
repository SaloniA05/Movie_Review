package com.project.Movies;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository; //a reference to ReviewRepository

    @Autowired
    private MongoTemplate mongoTemplate; //another way to talk to a database , apart from repo
    //used to form a new dynamic query and do the job  inside the Db without using the repo
    public Review createReview(String reviewBody,String imdbId){
        Review review= reviewRepository.insert(new Review(reviewBody));//a review object is created using the review constructor , and the constructor
        //sets body attribute of the Review object to the value recieved by "reviewBody"

        //to map the review body to a movie with the particular imdbid
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))//update review where the imdb id recieved matches the imdb id in the db
                .apply(new Update().push("reviewIds").value(review)) //our db contains a empty array of reviewIds, therefore we need to push the respective review into it
                .first();

        return review;
    }
}
