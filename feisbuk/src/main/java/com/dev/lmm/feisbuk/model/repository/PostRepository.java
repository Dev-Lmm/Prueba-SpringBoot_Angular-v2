package com.dev.lmm.feisbuk.model.repository;

import com.dev.lmm.feisbuk.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Override
    List<Post> findAll();
    @Override
    Optional<Post> findById(Long id);
    Optional<Post> findByTitle(String title);
    List<Post> findByPublicationDate(Date publicationDate);

}
