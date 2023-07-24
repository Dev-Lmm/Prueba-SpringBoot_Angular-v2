package com.dev.lmm.feisbuk.model.dto;

import com.dev.lmm.feisbuk.model.entity.Post;
import com.dev.lmm.feisbuk.model.entity.Profile;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class CommentDTO extends BaseDTO {
    private Long id;
    private String text;
    private Date publicationDate;
    private Profile profile;
    private Post post;
}
