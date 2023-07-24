package com.dev.lmm.feisbuk.model.repository;

import com.dev.lmm.feisbuk.model.entity.Profile;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    @Override
    List<Profile> findAll();
    @Override
    Optional<Profile> findById(Long id);
    Optional<Profile> findByName(String name);
    Optional<Profile> findByPhoneNumber(String phoneNumber);
    List<Profile> findByBirthdate(Date birthdate);

}
