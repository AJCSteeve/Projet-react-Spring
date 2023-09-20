package com.example.projetreactspringboot.repository;

import com.example.projetreactspringboot.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {

    List<Content> findByContentNameContainingIgnoreCase(String contentName);

    List<Content> findByBirthdateAfter(LocalDate birthdate);

    List<Content> findByContentType(Content.ContentType contentType);


}
