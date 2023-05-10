package com.elpatron.form.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

  public String uploadImage(MultipartFile file) throws Exception {
    ImageUtils imageUtils = new ImageUtils();
    ImageData imageData = new ImageData();
    log.info("saving image");
    if (imageRepository.existsByName(file.getOriginalFilename())) {
      imageData.setName(file.getOriginalFilename() + " (1)");
    } else {
      imageData.setName(file.getOriginalFilename());
    }
    imageData.setType(file.getContentType());
    imageData.setImageData(imageUtils.compressImage(file.getBytes()));
    ImageData saveImage = imageRepository.save(imageData);
    if (saveImage != null) {
      return imageData.getName();
    } else {
      throw new Exception("did not work");
    }
  }

  public byte[] downloadImage(String fileName) {
    Optional<ImageData> dbImageData = imageRepository.findByName(fileName);
    if (dbImageData.isPresent()) {
      ImageUtils imageUtils = new ImageUtils();
      byte[] image = imageUtils.decompressImage(dbImageData.get().getImageData());
      log.info("downloading image");
      return image;
    } else {
      return null;
    }
  }

}
