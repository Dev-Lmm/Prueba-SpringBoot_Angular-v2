package com.dev.lmm.feisbuk.model.reponse;

import com.dev.lmm.feisbuk.model.dto.MapperDTO;
import com.dev.lmm.feisbuk.model.dto.UserDTO;
import com.dev.lmm.feisbuk.model.entity.User;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class LoginResponse extends BaseResponse {

    private final UserDTO userDTO;

    @Builder(builderMethodName = "authenticationResponseBuilder")
    public LoginResponse(User user) {
        super(true, HttpStatus.OK, "User Authenticated successfully");
        this.userDTO = MapperDTO.fromEntity(user, UserDTO.class);
    }
}
