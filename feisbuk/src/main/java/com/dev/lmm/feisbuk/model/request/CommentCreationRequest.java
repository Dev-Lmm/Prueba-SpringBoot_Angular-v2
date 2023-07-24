package com.dev.lmm.feisbuk.model.request;

public record CommentCreationRequest(
        Long postId,
        Long profileId,
        String text
) {}
