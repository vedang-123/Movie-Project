package com.vedang.movies.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vedang.movies.Review;
@Repository
public interface ReviewRepository extends MongoRepository<Review,ObjectId>{

}
