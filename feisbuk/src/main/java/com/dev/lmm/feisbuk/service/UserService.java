package com.dev.lmm.feisbuk.service;

import com.dev.lmm.feisbuk.model.dto.MapperDTO;
import com.dev.lmm.feisbuk.model.dto.UserDTO;
import com.dev.lmm.feisbuk.model.entity.User;
import com.dev.lmm.feisbuk.model.reponse.LoginResponse;
import com.dev.lmm.feisbuk.model.reponse.UserResponse;
import com.dev.lmm.feisbuk.model.repository.UserRepository;
import com.dev.lmm.feisbuk.model.request.UserAuthenticationRequest;
import com.dev.lmm.feisbuk.model.request.UserEditionRequest;
import com.dev.lmm.feisbuk.model.request.UserRegistrationRequest;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final ProfileService profileService;

    public LoginResponse login(@RequestBody UserAuthenticationRequest request) {
        User user = userRepository.findByEmail(request.email()).orElseThrow();

        if (user.getPassword().equals(request.password())){
            return new LoginResponse(user);
        }

        return (LoginResponse) LoginResponse.builder().success(false).build();
    }

    public UserResponse register(UserRegistrationRequest request) {
        User user = User.builder()
                .username(request.username())
                .email(request.email())
                .password(request.password())
                .profile(profileService.create(request))
                .build();

        userRepository.save(user);

        return new UserResponse(user);
    }

    public UserDTO edit(UserEditionRequest request, Long id) {
        User existingUser = userRepository.findById(id).orElseThrow();

        existingUser.setUsername(request.username());
        existingUser.setEmail(request.email());
        existingUser.setPassword(request.password());

        userRepository.save(existingUser);

        return MapperDTO.fromEntity(existingUser, UserDTO.class);
    }

    @Transactional
    public UserDTO remove(Long id) {
        User existingUser = userRepository.findById(id).orElseThrow();

        userRepository.deleteById(id);

        return MapperDTO.fromEntity(existingUser, UserDTO.class);
    }

    public List<UserDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map((user) -> MapperDTO.fromEntity(user, UserDTO.class))
                .toList();
    }

    public UserDTO getCurrentUser(Long id) {
        User existingUser = userRepository.findById(id).orElseThrow();
        return MapperDTO.fromEntity(existingUser, UserDTO.class);
    }

}
