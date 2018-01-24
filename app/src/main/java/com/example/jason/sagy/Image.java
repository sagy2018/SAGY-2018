package com.example.jason.sagy;

/**
 * Created by goa on 23/1/18.
 */

import java.io.Serializable;

        import java.io.Serializable;

/**
 * Created by goa on 23/1/18.
 */
public class Image implements Serializable {
    private String name;
    private String urlOfImage;

    public Image() {
    }

    public Image(String name, String urlOfImage) {
        this.name = name;
        this.urlOfImage = urlOfImage;
    }

    public String getName() {
        return name;
    }

    public String getUrlOfImage() {
        return urlOfImage;
    }
}
