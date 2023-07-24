package com.dev.lmm.feisbuk.model.request;

public record UserAuthenticationRequest(
        String email,
        String password
) {}
