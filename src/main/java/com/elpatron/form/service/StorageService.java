package com.elpatron.form.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.elpatron.form.model.ImageData;
import com.elpatron.form.repository.ImageRepository;
import com.elpatron.form.util.ImageUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class StorageService {

  private final ImageRepository imageRepository;

  public String uploadImage(MultipartFile file) throws IOException {
    ImageUtils imageUtils = new ImageUtils();
    ImageData imageData = new ImageData();
    imageData.setName(file.getOriginalFilename());
    imageData.setType(file.getContentType());
    imageData.setImageData(imageUtils.compressImage(file.getBytes()));
    ImageData saveImage = imageRepository.save(imageData);
    if (saveImage != null) {
      return "file uploaded: " + file.getOriginalFilename();
    }
    return null;
  }

  public byte[] downloadImage(String fileName) {
    Optional<ImageData> dbImageData = imageRepository.findByName(fileName);
    if (dbImageData.isPresent()) {
      ImageUtils imageUtils = new ImageUtils();
      byte[] images = imageUtils.decompressImage(dbImageData.get().getImageData());
      return images;
    }
    return null;
  }

}
