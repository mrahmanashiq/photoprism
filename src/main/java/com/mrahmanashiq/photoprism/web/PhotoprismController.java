package com.mrahmanashiq.photoprism.web;

import com.mrahmanashiq.photoprism.model.PhotoprismModel;
import com.mrahmanashiq.photoprism.service.PhotoprismService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.*;

@RestController
public class PhotoprismController {

    @Autowired
    private PhotoprismService photoprismService;

    @GetMapping("/")
    public String getHello() {
        return "Hello World!";
    }

    @GetMapping("/photos")
    public Collection<PhotoprismModel> get() {
        return photoprismService.get();
    }

    @GetMapping("/photos/{id}")
    public PhotoprismModel get(@PathVariable String id) {
        PhotoprismModel photo = photoprismService.get(id);
        if (photo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Photo not found");
        }
        return photo;
    }

    @DeleteMapping("/photos/{id}")
    public void delete(@PathVariable String id) {
        PhotoprismModel photo = photoprismService.get(id);
        if (photo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Photo not found");
        }
        photoprismService.remove(id);
    }

    @PostMapping("/photos")
    public PhotoprismModel create(@RequestPart("data") MultipartFile file) throws IOException {
        PhotoprismModel photo = photoprismService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
        return photo;
    }
}
