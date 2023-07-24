package com.dev.lmm.feisbuk.model.request;

import com.dev.lmm.feisbuk.model.entity.Profile;

import java.util.Date;

public record UserRegistrationRequest(
        String username,
        String email,
        String password,
        String name,
        String lastName,
        Date birthdate,
        String phoneNumber,
        Profile profile
) {}
