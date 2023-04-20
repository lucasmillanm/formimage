package com.elpatron.form.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class FormData {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Size(min = 2, max = 30)
  @NotBlank(message = "firstName cannot be empty")
  private String firstName;

  @Size(min = 2, max = 30)
  @NotBlank(message = "lastName cannot be empty")
  private String lastName;

  @Size(min = 2, max = 64)
  @NotBlank(message = "description cannot be empty")
  private String description;

//  private ImageData photo;

}
