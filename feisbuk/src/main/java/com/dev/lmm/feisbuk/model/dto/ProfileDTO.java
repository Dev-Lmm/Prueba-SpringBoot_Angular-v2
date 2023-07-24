package com.dev.lmm.feisbuk.model.dto;

import com.dev.lmm.feisbuk.model.entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProfileDTO extends BaseDTO {
    private Long id;
    private String name;
    private String lastName;
    private Date birthdate;
    private String phoneNumber;
    private List<PostDTO> posts;
}
