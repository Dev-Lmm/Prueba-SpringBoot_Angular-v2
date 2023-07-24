package com.dev.lmm.feisbuk.controller;

import com.dev.lmm.feisbuk.model.dto.CommentDTO;
import com.dev.lmm.feisbuk.model.reponse.CommentResponse;
import com.dev.lmm.feisbuk.model.request.CommentCreationRequest;
import com.dev.lmm.feisbuk.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService service;

    @GetMapping("/index")
    public ResponseEntity<List<CommentDTO>> index() {
        List<CommentDTO> response = service.findAll();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity<CommentResponse> create(@RequestBody CommentCreationRequest request) {
        CommentResponse response = service.create(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/edit")
    public ResponseEntity<CommentDTO> edit(@RequestBody CommentCreationRequest request, @RequestParam Long postId ) {
        CommentDTO response = service.edit(request, postId);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<CommentDTO> delete(@RequestParam Long id) {
        CommentDTO response = service.delete(id);
        return ResponseEntity.ok(response);
    }
}
