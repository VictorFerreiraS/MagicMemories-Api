package com.example.magicimagessrc.single_image;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/images_src")
@AllArgsConstructor
public class SingleImageController {
    private final SingleImageService singleImageService;

    @GetMapping
    public List<SingleImage> fetchAllImages() {
        return singleImageService.getAllImages();
    }

    @PostMapping
    public void  postImages(List<SingleImage> imagesList) {
        imagesList.forEach(li -> {
            String singleImageSrc = li.getSingleImageSRC();
            System.out.println(singleImageSrc);
            System.out.println(imagesList);
            if (singleImageService.findImageBySrc(singleImageSrc)) {
                System.out.println("An image with " + li + " already exists");
                throw new IllegalArgumentException("An image with " + li + " already exists");
            } else {
                System.out.println("inserting");
                singleImageService.postImages(li);
            }
        });
     }

}
