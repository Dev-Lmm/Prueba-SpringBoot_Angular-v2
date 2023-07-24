package com.dev.lmm.feisbuk.model.reponse;

import com.dev.lmm.feisbuk.model.dto.MapperDTO;
import com.dev.lmm.feisbuk.model.dto.UserDTO;
import com.dev.lmm.feisbuk.model.entity.User;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserResponse extends BaseResponse {

    private final UserDTO userDTO;

    @Builder(builderMethodName = "userRegistrationResponseBuilder")
    public UserResponse(User user) {
        super(true, HttpStatus.OK, "User registered successfully");
        this.userDTO = MapperDTO.fromEntity(user, UserDTO.class);
    }
}
