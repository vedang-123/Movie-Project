package com.vedang.movies.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vedang.movies.Movie;
import java.util.Optional;

@Repository
public interface MovieRepository  extends MongoRepository<Movie,ObjectId>{
   Optional<Movie> findByImdbId(String imdbid);
}
