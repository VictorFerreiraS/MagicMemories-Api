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
    private String singleImageSRC;

    private Boolean matched = true;

//  GETTER AND SETTER
    public String getSingleImageSRC() {
        return singleImageSRC;
    }

    public void setSingleImageSRC(String singleImageSRC) {
        this.singleImageSRC = singleImageSRC;
    }

//    CONSTRUCTORS
    public SingleImage() {
    }

    public SingleImage(String singleImageSRC) {
        this.singleImageSRC = singleImageSRC;
    }

    public SingleImage(String id, String singleImageSRC, Boolean matched) {
        this.id = id;
        this.singleImageSRC = singleImageSRC;
        this.matched = matched;
    }

    public SingleImage(String singleImageSRC, Boolean matched) {
        this.singleImageSRC = singleImageSRC;
        this.matched = matched;
    }
}

