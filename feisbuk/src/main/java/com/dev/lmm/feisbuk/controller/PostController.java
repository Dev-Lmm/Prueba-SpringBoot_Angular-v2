package com.dev.lmm.feisbuk.controller;

import com.dev.lmm.feisbuk.model.dto.PostDTO;
import com.dev.lmm.feisbuk.model.reponse.PostResponse;
import com.dev.lmm.feisbuk.model.request.PostCreationRequest;
import com.dev.lmm.feisbuk.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService service;

    @GetMapping("/index")
    public ResponseEntity<List<PostDTO>> index() {
        List<PostDTO> response = service.findAll();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity<PostResponse> create(@RequestBody PostCreationRequest request) {
        PostResponse response = service.create(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDTO> edit(@RequestBody PostCreationRequest request, @PathVariable Long id) {
        PostDTO response = service.edit(request, id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PostDTO> delete(@PathVariable Long id) {
        PostDTO response = service.delete(id);
        return ResponseEntity.ok(response);
    }
}
