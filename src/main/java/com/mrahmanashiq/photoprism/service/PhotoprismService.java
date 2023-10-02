package com.mrahmanashiq.photoprism.service;

import com.mrahmanashiq.photoprism.model.PhotoprismModel;
import com.mrahmanashiq.photoprism.repository.PhotoprismRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoprismService {

    @Autowired
    private PhotoprismRepository photoprismRepository;

    public Iterable<PhotoprismModel> get() {
        return photoprismRepository.findAll();
    }

    public PhotoprismModel get(Integer id) {
        return photoprismRepository.findById(id).orElse(null);
    }

    public void remove(Integer id) {
        photoprismRepository.deleteById(id);
    }

    public PhotoprismModel save(String fileName, String contentType, byte[] data) {
        PhotoprismModel photo = new PhotoprismModel();
        photo.setContentType(contentType);
        photo.setFileName(fileName);
        photo.setData(data);
        photoprismRepository.save(photo);

        return photo;
    }
}
