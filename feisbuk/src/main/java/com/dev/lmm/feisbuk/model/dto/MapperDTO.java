package com.dev.lmm.feisbuk.model.dto;

import com.dev.lmm.feisbuk.model.entity.BaseEntity;
import org.modelmapper.ModelMapper;

public class MapperDTO {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static <T extends BaseEntity, U extends BaseDTO> U fromEntity(T source, Class<U> destinationType) {
        return modelMapper.map(source, destinationType);
    }

}
