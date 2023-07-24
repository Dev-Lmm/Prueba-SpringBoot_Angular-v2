package com.dev.lmm.feisbuk.model.request;

import java.util.Date;

public record PostCreationRequest(
        String title,
        String text,
        Date publicationDate,
        Long profileId
) {}
