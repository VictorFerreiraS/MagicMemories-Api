package com.example.magicimagessrc;

import com.example.magicimagessrc.single_image.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class MagicImagesSrcApplication {
    public static void main(String[] args) {
        SpringApplication.run(MagicImagesSrcApplication.class, args);
    }
    @Bean
    CommandLineRunner runner(SingleImageRepository repository, SingleImageController controller) {
        return args -> {
//  Creating local and database lists
            List<SingleImage> localImagesList = new ArrayList<>(List.of(
                    new SingleImage("/img/helmet-1.png"),
                    new SingleImage("/img/potion-1.png"),
                    new SingleImage("/img/ring-1.png"),
                    new SingleImage("/img/scroll-1.png"),
                    new SingleImage("/img/shield-1.png"),
                    new SingleImage("/img/sword-1.png")
            ));
            List<SingleImage> databaseImagesList = controller.fetchAllImages();

            //  Lists with the src only
            List<String> localImagesSrcs = localImagesList.stream()
                    .map(il -> il.getSingleImageSRC())
                    .collect(Collectors.toList());
            List<String> databaseImagesSrcs = databaseImagesList.stream()
                    .map(SingleImage::getSingleImageSRC)
                    .toList();

                localImagesSrcs.forEach(li -> {
                    if (databaseImagesSrcs.stream().anyMatch(dbi -> li.equals(dbi))) {
                        System.out.println("An image with " + li + " already exists");
                        throw new IllegalArgumentException("An image with " + li + " already exists");
                    } else {
                        System.out.println("inserting");
                        repository.insert(localImagesList);
                    }
//                System.out.println(databaseImagesSrcs.stream().anyMatch(dbi -> li.equals(dbi)));
                });

        };
    }
}

