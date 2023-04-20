package com.elpatron.form.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.elpatron.form.model.FormData;
import com.elpatron.form.repository.FormRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/form")
@RequiredArgsConstructor
public class FormController {

  /*private final FormRepository formRepository;

  @PostMapping("/formdata")
  public ResponseEntity<?> createFormData(@ModelAttribute FormData formData) {
    try {
      MultipartFile photo = formData.getPhotoFile();
      byte[] photoData = photo.getBytes();
      formData.setPhoto(photoData);
      formRepository.save(formData);
      return ResponseEntity.ok().build();
    } catch (IOException e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @GetMapping("/formdata")
  public List<FormData> getAllForms () {
    return formRepository.findAll();
  }*/

}
