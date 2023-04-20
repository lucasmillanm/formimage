package com.elpatron.form.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elpatron.form.model.ImageData;

@Repository
public interface ImageRepository extends JpaRepository<ImageData, Long> {

  Optional<ImageData> findByName(String fileName);
}
