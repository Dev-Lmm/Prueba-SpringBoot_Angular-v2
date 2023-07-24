package com.dev.lmm.feisbuk.model.reponse;

import com.dev.lmm.feisbuk.model.dto.CommentDTO;
import com.dev.lmm.feisbuk.model.dto.MapperDTO;
import com.dev.lmm.feisbuk.model.entity.Comment;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CommentResponse extends BaseResponse {

    private final CommentDTO commentDTO;

    @Builder(builderMethodName = "commentCreationResponseBuilder")
    public CommentResponse(Comment comment) {
        super(true, HttpStatus.OK, "Comment created successfully");
        this.commentDTO = MapperDTO.fromEntity(comment, CommentDTO.class);
    }
}
