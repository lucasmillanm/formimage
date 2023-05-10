package com.elpatron.form.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.elpatron.form.model.Form;
import com.elpatron.form.service.FormService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/form")
@RequiredArgsConstructor
public class FormController {

  private final FormService formService;

  @PostMapping
  public ResponseEntity<?> submitForm(
      @RequestParam String fullName,
      @RequestParam String age,
      @RequestParam("image") MultipartFile multipartFile
  ) throws Exception {
    Form form = formService.submitForm(fullName, age, multipartFile);
    return ResponseEntity.ok().body(form);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getForm(
      @PathVariable Long id
  ) throws Exception {
    Form form = formService.getForm(id);
    return ResponseEntity.ok().body(form);
  }

}
