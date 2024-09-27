package com.vedang.movies.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedang.movies.Movie;
import com.vedang.movies.repo.MovieRepository;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    public List<Movie>allMovies(){
        return movieRepository.findAll();
    }

    public java.util.Optional<Movie> singleMovie(String imdbid){
        return movieRepository.findByImdbId(imdbid);
    }
}
