package com.dev.lmm.feisbuk.model.reponse;

import com.dev.lmm.feisbuk.model.dto.MapperDTO;
import com.dev.lmm.feisbuk.model.dto.PostDTO;
import com.dev.lmm.feisbuk.model.entity.Post;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PostResponse extends BaseResponse {

    private final PostDTO postDTO;

    @Builder(builderMethodName = "postCreationResponseBuilder")
    public PostResponse(Post post) {
        super(true, HttpStatus.OK, "Post created successfully");
        this.postDTO = MapperDTO.fromEntity(post, PostDTO.class);
    }
}
