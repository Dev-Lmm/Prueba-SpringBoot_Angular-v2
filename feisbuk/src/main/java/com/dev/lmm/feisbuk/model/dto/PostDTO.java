package com.dev.lmm.feisbuk.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PostDTO extends BaseDTO {
    private Long id;
    private String title;
    private String text;
    private Date publicationDate;
    private List<CommentDTO> comments;
}
