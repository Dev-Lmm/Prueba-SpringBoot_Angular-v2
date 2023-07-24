package com.dev.lmm.feisbuk.model.repository;

import com.dev.lmm.feisbuk.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Override
    List<Comment> findAll();
    @Override
    Optional<Comment> findById(Long id);
    List<Comment> findByPublicationDate(Date publicationDate);

}
