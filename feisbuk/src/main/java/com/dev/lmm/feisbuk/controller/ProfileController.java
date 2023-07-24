package com.dev.lmm.feisbuk.controller;

import com.dev.lmm.feisbuk.model.dto.ProfileDTO;
import com.dev.lmm.feisbuk.model.reponse.ProfileResponse;
import com.dev.lmm.feisbuk.model.request.ProfileEditionRequest;
import com.dev.lmm.feisbuk.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    private final ProfileService service;

    @GetMapping("/index")
    public ResponseEntity<List<ProfileDTO>> index() {
        List<ProfileDTO> response = service.findAll();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfileResponse> edit(@RequestBody ProfileEditionRequest request, @PathVariable Long id) {
        ProfileResponse response = service.edit(request, id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileDTO> profile(@PathVariable Long id) {
        ProfileDTO response = service.getCurrentProfile(id);
        return ResponseEntity.ok(response);
    }
}
