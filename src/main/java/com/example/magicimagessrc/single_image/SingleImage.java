package com.example.magicimagessrc.single_image;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class SingleImage {
    @Id
    private String id;
    @Indexed(unique = true)
    private String SingleImageSRC;

    private Boolean matched = true;

    public SingleImage() {
    }

    public SingleImage(String id, String singleImageSRC, Boolean matched) {
        this.id = id;
        SingleImageSRC = singleImageSRC;
        this.matched = matched;
    }

    public SingleImage(String singleImageSRC) {
        SingleImageSRC = singleImageSRC;
    }

    public SingleImage(String singleImageSRC, Boolean matched) {
        SingleImageSRC = singleImageSRC;
        this.matched = matched;
    }


    public String getSingleImageSRC() {
        return SingleImageSRC;
    }


}

