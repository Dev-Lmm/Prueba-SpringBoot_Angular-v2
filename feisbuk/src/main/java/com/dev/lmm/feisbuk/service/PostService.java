package com.dev.lmm.feisbuk.service;

import com.dev.lmm.feisbuk.model.dto.MapperDTO;
import com.dev.lmm.feisbuk.model.dto.PostDTO;
import com.dev.lmm.feisbuk.model.entity.Post;
import com.dev.lmm.feisbuk.model.reponse.PostResponse;
import com.dev.lmm.feisbuk.model.repository.PostRepository;
import com.dev.lmm.feisbuk.model.repository.ProfileRepository;
import com.dev.lmm.feisbuk.model.request.PostCreationRequest;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;
    private final ProfileRepository profileRepository;


    public PostResponse create(PostCreationRequest request) {
        Post post = Post.builder()
                .title(request.title())
                .text(request.text())
                .publicationDate(request.publicationDate())
                .profile(profileRepository.findById(request.profileId()).orElseThrow())
                .build();

        postRepository.save(post);

        return new PostResponse(post);
    }

    public PostDTO edit(PostCreationRequest request, Long id) {
        Post existingPost = postRepository.findById(id).orElseThrow();

        existingPost.setTitle(request.title());
        existingPost.setText(request.text());
        existingPost.setPublicationDate(request.publicationDate());

        postRepository.save(existingPost);

        return MapperDTO.fromEntity(existingPost, PostDTO.class);
    }

    @Transactional
    public PostDTO delete(Long id) {
        Post existingPost = postRepository.findById(id).orElseThrow();

        postRepository.deleteById(id);

        return MapperDTO.fromEntity(existingPost, PostDTO.class);
    }

    public List<PostDTO> findAll() {
        return postRepository.findAll()
                .stream()
                .map((post) -> MapperDTO.fromEntity(post, PostDTO.class))
                .toList();
    }
}
