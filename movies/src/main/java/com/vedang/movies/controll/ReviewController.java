package com.vedang.movies.controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.data.mongodb.core.aggregation.VariableOperators.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import com.vedang.movies.Review;
import com.vedang.movies.service.ReviewService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
     private ReviewService reviewService;
     @PostMapping
     public ResponseEntity<Review>createReview(@RequestBody Map<String ,String> paylod){
        return  new ResponseEntity<Review>(reviewService.createReview(paylod.get("reviewBody"),paylod.get("imdbId")),HttpStatus.CREATED);
     }
}
