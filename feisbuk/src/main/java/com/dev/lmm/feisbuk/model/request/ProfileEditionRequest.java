package com.dev.lmm.feisbuk.model.request;

import java.util.Date;

public record ProfileEditionRequest(
        String name,
        String lastName,
        Date birthdate,
        String phoneNumber
) {}
