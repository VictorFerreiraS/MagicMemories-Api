package com.example.magicimagessrc.single_image;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class SingleImageService {
    private final SingleImageRepository repository;

    public List<SingleImage> getAllImages() {
        return repository.findAll();
    }

    public Boolean findImageBySrc(String src) {
        if (repository.findSingleImageBySingleImageSRC(src).isPresent()){
            return false;
        } else {
            return true;
        }
    }

    public void postImages(SingleImage singleImage) {
            repository.insert(singleImage);
    }
}
