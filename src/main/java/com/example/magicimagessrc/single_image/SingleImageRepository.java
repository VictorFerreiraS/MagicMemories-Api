package com.example.magicimagessrc.single_image;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SingleImageRepository
        extends MongoRepository<SingleImage, String> {
    Optional<SingleImage> findSingleImageBySingleImageSRC();
}
