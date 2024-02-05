package com.project.Movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    //creating a function to access movies by IMDB ID boz we dont want to expose objectid to all the users
    //this is a dynamic query using property name and spring is smart enough to perform the operation
    Optional<Movie> findMovieByImdbId(String imdbId);
}
