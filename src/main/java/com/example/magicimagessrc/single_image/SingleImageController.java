package com.example.magicimagessrc.single_image;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
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

}
