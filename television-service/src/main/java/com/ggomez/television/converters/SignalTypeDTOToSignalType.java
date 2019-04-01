package com.ggomez.television.converters;

import com.ggomez.television.dtos.SignalTypeDTO;
import com.ggomez.television.model.SignalType;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class SignalTypeDTOToSignalType implements Converter<SignalTypeDTO, SignalType> {
    @Synchronized
    @Nullable
    @Override
    public SignalType convert(SignalTypeDTO source) {
        if (source == null) {
            return null;
        }

        final SignalType signalType = new SignalType();
        signalType.setSignalTypeId(source.getSignalTypeId());
        signalType.setDescription(source.getDescription());
        return signalType;
    }
}
