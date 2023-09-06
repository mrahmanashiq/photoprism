package com.mrahmanashiq.photoprism.web;

import com.mrahmanashiq.photoprism.model.PhotoprismModel;
import com.mrahmanashiq.photoprism.service.PhotoprismService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class DownloadController {

    @Autowired
    private PhotoprismService photoprismService;

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable String id) {
        PhotoprismModel photo = photoprismService.get(id);
        if (photo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Photo not found");
        }


        byte[] data = photo.getData();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDisposition(ContentDisposition
                .builder("attachment")
                .filename(photo.getFileName())
                .build());
        headers.setContentType(MediaType.valueOf(photo.getContentType()));

        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }
}
