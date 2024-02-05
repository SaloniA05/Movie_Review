package com.project.Movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document (collection = "movies")//will let the framework know that this class sheet represents each doc in the movies collection
@Data //helps automatically generate getters and setters for all fields
@AllArgsConstructor //annotation for creating a constructor that takes in all the private fields as arguments
@NoArgsConstructor //constructor that takes in no arguments
public class Movie {
    @Id //for the framework to know that this property should be treated as a unique identifier
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String>genres;
    private List<String>backdrops;
    @DocumentReference // will cause the database to store only the IDs of the review nd the reviews will be in a separate collection
    private List<Review> reviewIds; //embedded relationship



}
