package com.marksandspencer.search.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.marksandspencer.search.model.ProductDetailsDocument;

@Repository
public interface ProductDetailsRepository extends MongoRepository<ProductDetailsDocument, String> {
}
