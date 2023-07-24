package com.dev.lmm.feisbuk.model.dto;

import com.dev.lmm.feisbuk.model.entity.Profile;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO extends BaseDTO {
    private Long id;
    private String username;
    private String email;
    private Profile profile;
}
