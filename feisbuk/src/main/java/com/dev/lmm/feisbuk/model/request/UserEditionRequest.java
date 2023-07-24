package com.dev.lmm.feisbuk.model.request;

public record UserEditionRequest(
        String username,
        String email,
        String password
) {}
