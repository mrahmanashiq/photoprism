package com.mrahmanashiq.photoprism;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhotoprismController {

    private final List<PhotoModel> db = List.of(new PhotoModel("1", "photo1.jpg"));

    @GetMapping("/")
    public String getHello() {
        return "Hello World!";
    }

    @GetMapping("/photos")
    public List<PhotoModel> get() {
        return db;
    }
}
