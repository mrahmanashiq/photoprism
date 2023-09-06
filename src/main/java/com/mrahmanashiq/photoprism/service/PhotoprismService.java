package com.mrahmanashiq.photoprism.service;

import com.mrahmanashiq.photoprism.model.PhotoprismModel;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class PhotoprismService {

    private Map<String, PhotoprismModel> db = new HashMap<>() {{
        put("1", new PhotoprismModel("1", "photo1.jpg"));
        put("2", new PhotoprismModel("2", "photo2.jpg"));
        put("3", new PhotoprismModel("3", "photo3.jpg"));
    }};

    public Collection<PhotoprismModel> get() {
        return db.values();
    }

    public PhotoprismModel get(String id) {
        return db.get(id);
    }

    public PhotoprismModel remove(String id) {
        return db.remove(id);
    }

    public PhotoprismModel save(String fileName, String contentType, byte[] data) {
        PhotoprismModel photo = new PhotoprismModel();
        photo.setContentType(contentType);
        photo.setId(UUID.randomUUID().toString());
        photo.setFileName(fileName);
        photo.setData(data);
        db.put(photo.getId(), photo);

        return photo;
    }
}
