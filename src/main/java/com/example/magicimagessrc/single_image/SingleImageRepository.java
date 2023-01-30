package com.example.magicimagessrc.single_image;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SingleImageRepository
        extends MongoRepository<SingleImage, String> {
    Optional<SingleImage> findSingleImageBySingleImageSRC(String SingleImageSRC);
}
