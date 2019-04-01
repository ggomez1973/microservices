package com.ggomez.television.converters;

import com.ggomez.television.dtos.SignalTypeDTO;
import com.ggomez.television.model.SignalType;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class SignalTypeToSignalTypeDTO implements Converter<Mono<SignalType>, SignalTypeDTO> {
    @Synchronized
    @Nullable
    @Override
    public SignalTypeDTO convert(Mono<SignalType> source) {
        if (source == null) {
            return null;
        }
        final SignalTypeDTO signalType = new SignalTypeDTO();
        source.subscribe(
                i ->  {
                    signalType.setSignalTypeId(i.getSignalTypeId());
                    signalType.setDescription(i.getDescription());
                }
        );
        return signalType;
    }
}
