package com.elpatron.form.service;

import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.elpatron.form.model.Form;
import com.elpatron.form.repository.FormRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class FormService {

  private final FormRepository formRepository;
  private final StorageService storageService;

  public Form submitForm(String fullName, String age, MultipartFile multipartFile) throws Exception {
    Form form = new Form();
    form.setFullName(fullName);
    form.setAge(age);
    String imageName = storageService.uploadImage(multipartFile);
    form.setImageName(imageName);
    return formRepository.save(form);
  }

  public Form getForm(Long id) throws Exception {
    Form existingForm = formRepository.findById(id)
        .orElseThrow(() -> new Exception("form not found"));
    log.info("getting form");
    return existingForm;
  }

}
