package com.mrahmanashiq.photoprism;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
public class PhotoprismController {

    private Map<String, PhotoModel> db = new HashMap<>() {{
        put("1", new PhotoModel("1", "photo1.jpg"));
        put("2", new PhotoModel("2", "photo2.jpg"));
        put("3", new PhotoModel("3", "photo3.jpg"));
    }};

    @GetMapping("/")
    public String getHello() {
        return "Hello World!";
    }

    @GetMapping("/photos")
    public Collection<PhotoModel> get() {
        return db.values();
    }

    @GetMapping("/photos/{id}")
    public PhotoModel get(@PathVariable String id) {
        PhotoModel photo = db.get(id);
        if (photo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Photo with id %s not found", id));
        }
        return photo;
    }
}
