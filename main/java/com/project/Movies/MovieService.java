package com.project.Movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired //let the framework know that we want the framework to instantiate this class here ,
    //annotation ensures that the MovieRepository dependency is automatically injected into the service.
    private MovieRepository movieRepository;
    public List<Movie> allMovies(){
        return movieRepository.findAll();

    }
    public Optional<Movie> singleMovie(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
