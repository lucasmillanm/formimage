package com.elpatron.form.model;

import jakarta.persistence.Column;
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
public class ImageData {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Size(min = 2, max = 30)
  @NotBlank(message = "firstName cannot be empty")
  private String name;

  @Size(min = 2, max = 30)
  @NotBlank(message = "lastName cannot be empty")
  private String type;

  @Lob
  @Column(length = 5000)
  private byte[] imageData;

}
