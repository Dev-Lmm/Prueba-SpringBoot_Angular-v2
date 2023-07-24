package com.dev.lmm.feisbuk.service;

import com.dev.lmm.feisbuk.model.dto.MapperDTO;
import com.dev.lmm.feisbuk.model.dto.ProfileDTO;
import com.dev.lmm.feisbuk.model.entity.Post;
import com.dev.lmm.feisbuk.model.entity.Profile;
import com.dev.lmm.feisbuk.model.reponse.ProfileResponse;
import com.dev.lmm.feisbuk.model.repository.ProfileRepository;
import com.dev.lmm.feisbuk.model.request.ProfileEditionRequest;
import com.dev.lmm.feisbuk.model.request.UserRegistrationRequest;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileResponse edit(ProfileEditionRequest request, Long id) {
        Profile existingProfile = profileRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.valueOf(Profile.class)));

        existingProfile.setName(request.name());
        existingProfile.setLastName(request.lastName());
        existingProfile.setBirthdate(request.birthdate());
        existingProfile.setPhoneNumber(request.phoneNumber());

        profileRepository.save(existingProfile);

        return new ProfileResponse(existingProfile);
    }

    public List<ProfileDTO> findAll() {
        return profileRepository.findAll()
                .stream()
                .map((profile) -> MapperDTO.fromEntity(profile, ProfileDTO.class))
                .toList();
    }

    public ProfileDTO getCurrentProfile(Long id) {
        Profile existingProfile = profileRepository.findById(id).orElseThrow();
        return MapperDTO.fromEntity(existingProfile, ProfileDTO.class);
    }

    Profile create(UserRegistrationRequest request){
        Profile profile = Profile.builder()
                .name(request.name())
                .lastName(request.lastName())
                .birthdate(request.birthdate())
                .phoneNumber(request.phoneNumber())
                .build();

        profileRepository.save(profile);

        return profile;
    }

    @Transactional
    public ProfileDTO remove(Long id) {
        Profile existingProfile = profileRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.valueOf(Profile.class)));

        profileRepository.deleteById(id);

        return MapperDTO.fromEntity(existingProfile, ProfileDTO.class);
    }
}
