package com.vedang.movies.controll;

import java.util.List;
import java.util.Optional;

//import org.apache.el.stream.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedang.movies.Movie;
import com.vedang.movies.service.MovieService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;
   @GetMapping
   public ResponseEntity<List<Movie>>getallmovies(){
       return  new ResponseEntity<List<Movie>>(movieService.allMovies(),HttpStatus.OK);
   }
   @GetMapping("/{imdbid}")
   public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String  imdbid){

    return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbid),HttpStatus.OK);
   }

}
