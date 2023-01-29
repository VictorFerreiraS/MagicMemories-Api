package com.example.magicimagessrc;

import com.example.magicimagessrc.single_image.SingleImage;
import com.example.magicimagessrc.single_image.SingleImageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MagicImagesSrcApplication {

    List<SingleImage> images = new ArrayList<>();

    SingleImage singleImage1 = new SingleImage("/img/helmet-1.png");
    SingleImage singleImage2 = new SingleImage("/img/potion-1.png");
    SingleImage singleImage3 = new SingleImage("/img/ring-1.png");
    SingleImage singleImage4 = new SingleImage("/img/scroll-1.png");
    SingleImage singleImage5 = new SingleImage("/img/shield-1.png");
    SingleImage singleImage6 = new SingleImage("/img/sword-1.png");


    public static void main(String[] args) {
        SpringApplication.run(MagicImagesSrcApplication.class, args);
    }



    @Bean

    CommandLineRunner runner(SingleImageRepository repository, MongoTemplate mongoTemplate) {

        return args -> {
              images.add(singleImage1);
              images.add(singleImage2);
              images.add(singleImage3);
              images.add(singleImage4);
              images.add(singleImage5);
              images.add(singleImage6);

              images.forEach(image-> {
                  if (image.getSingleImageSRC() == image.getSingleImageSRC()) {
                      throw new IllegalStateException("An image with the " + image.getSingleImageSRC() + " Already exists!");
                  } else {
                      repository.insert(images);
                  }
                  System.out.println(image.getSingleImageSRC());
              });
        };
    }
}

