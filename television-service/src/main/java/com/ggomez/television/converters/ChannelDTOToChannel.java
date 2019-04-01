package com.ggomez.television.converters;

import com.ggomez.television.dtos.ChannelDTO;
import com.ggomez.television.model.Channel;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.lang.Nullable;

@Component
public class ChannelDTOToChannel implements Converter<ChannelDTO, Channel> {
    private final SignalTypeDTOToSignalType signalConverter;

    public ChannelDTOToChannel(SignalTypeDTOToSignalType signalConverter) {
        this.signalConverter = signalConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public Channel convert(ChannelDTO source) {
        if (source == null) {
            return null;
        }

        final Channel channel = new Channel();
        channel.setChannelId(source.getChannelId());
        channel.setName(source.getName());
        channel.setGridNumber(source.getGridNumber());
        channel.setDescription(source.getDescription());
        channel.setType(signalConverter.convert(source.getType()));
        return channel;
    }
}
