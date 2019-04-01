package com.ggomez.television.converters;

import com.ggomez.television.dtos.ChannelDTO;
import com.ggomez.television.model.Channel;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class ChannelToChannelDTO implements Converter<Mono<Channel>, ChannelDTO> {
    private final SignalTypeToSignalTypeDTO signalConverter;

    public ChannelToChannelDTO(SignalTypeToSignalTypeDTO signalConverter) {
        this.signalConverter = signalConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public ChannelDTO convert(Mono<Channel> source) {

        if (source == null) {
            return null;
        }
        final ChannelDTO channel = new ChannelDTO();
        source.subscribe(
                i ->  {
                    channel.setChannelId(i.getChannelId());
                    channel.setName(i.getName());
                    channel.setGridNumber(i.getGridNumber());
                    channel.setDescription(i.getDescription());
                    channel.setType(signalConverter.convert(Mono.just(i.getType())));
                }
        );
        return channel;
    }
}
