package com.dev.lmm.feisbuk.service;

import com.dev.lmm.feisbuk.model.dto.CommentDTO;
import com.dev.lmm.feisbuk.model.dto.MapperDTO;
import com.dev.lmm.feisbuk.model.entity.Comment;
import com.dev.lmm.feisbuk.model.reponse.CommentResponse;
import com.dev.lmm.feisbuk.model.repository.CommentRepository;
import com.dev.lmm.feisbuk.model.repository.PostRepository;
import com.dev.lmm.feisbuk.model.repository.ProfileRepository;
import com.dev.lmm.feisbuk.model.request.CommentCreationRequest;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final ProfileRepository profileRepository;

    public CommentResponse create(CommentCreationRequest request) {
        Comment comment = Comment.builder()
                .text(request.text())
                .post(postRepository.findById(request.postId()).orElseThrow())
                .profile(profileRepository.findById(request.profileId()).orElseThrow())
                .build();

        commentRepository.save(comment);

        return new CommentResponse(comment);
    }

    public CommentDTO edit(CommentCreationRequest request, Long id) {
        Comment existingComment = commentRepository.findById(id).orElseThrow();

        existingComment.setText(request.text());

        commentRepository.save(existingComment);

        return MapperDTO.fromEntity(existingComment, CommentDTO.class);
    }

    @Transactional
    public CommentDTO delete(Long id) {
        Comment existingComment = commentRepository.findById(id).orElseThrow();

        commentRepository.deleteById(id);

        return MapperDTO.fromEntity(existingComment, CommentDTO.class);
    }

    public List<CommentDTO> findAll() {
        return commentRepository.findAll()
                .stream()
                .map(comment -> MapperDTO.fromEntity(comment, CommentDTO.class))
                .toList();
    }
}
