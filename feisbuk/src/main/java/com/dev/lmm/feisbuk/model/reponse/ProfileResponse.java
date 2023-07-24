package com.dev.lmm.feisbuk.model.reponse;

import com.dev.lmm.feisbuk.model.dto.MapperDTO;
import com.dev.lmm.feisbuk.model.dto.ProfileDTO;
import com.dev.lmm.feisbuk.model.entity.Profile;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ProfileResponse extends BaseResponse {

    private final ProfileDTO profileDTO;

    @Builder(builderMethodName = "profileEditionResponseBuilder")
    public ProfileResponse(Profile profile) {
        super(true, HttpStatus.OK, "Profile edited successfully");
        this.profileDTO = MapperDTO.fromEntity(profile, ProfileDTO.class);
    }
}
