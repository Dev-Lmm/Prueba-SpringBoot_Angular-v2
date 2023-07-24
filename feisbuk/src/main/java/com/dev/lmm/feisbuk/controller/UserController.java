package com.dev.lmm.feisbuk.controller;

import com.dev.lmm.feisbuk.model.dto.UserDTO;
import com.dev.lmm.feisbuk.model.reponse.LoginResponse;
import com.dev.lmm.feisbuk.model.reponse.UserResponse;
import com.dev.lmm.feisbuk.model.request.UserAuthenticationRequest;
import com.dev.lmm.feisbuk.model.request.UserEditionRequest;
import com.dev.lmm.feisbuk.model.request.UserRegistrationRequest;
import com.dev.lmm.feisbuk.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    @GetMapping("/index")
    public ResponseEntity<List<UserDTO>> index() {
        List<UserDTO> response = service.findAll();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRegistrationRequest request) {
        UserResponse response = service.register(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> edit(@RequestBody UserEditionRequest request, @PathVariable Long id) {
        UserDTO response = service.edit(request, id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDTO> remove(@PathVariable Long id) {
        UserDTO response = service.remove(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/")
    public ResponseEntity<LoginResponse> login(@RequestBody UserAuthenticationRequest request) {
        LoginResponse response = service.login(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> profile(@PathVariable Long id) {
        UserDTO response = service.getCurrentUser(id);
        return ResponseEntity.ok(response);
    }
}
