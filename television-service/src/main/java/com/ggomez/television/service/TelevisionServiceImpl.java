package com.ggomez.television.service;

import com.ggomez.television.converters.ChannelDTOToChannel;
import com.ggomez.television.converters.ChannelToChannelDTO;
import com.ggomez.television.converters.SignalTypeDTOToSignalType;
import com.ggomez.television.converters.SignalTypeToSignalTypeDTO;
import com.ggomez.television.dtos.ChannelDTO;
import com.ggomez.television.dtos.SignalTypeDTO;
import com.ggomez.television.model.Channel;
import com.ggomez.television.model.SignalType;
import com.ggomez.television.repositories.ChannelRepository;
import com.ggomez.television.repositories.SignalTypeRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TelevisionServiceImpl implements TelevisionService {
    private final ChannelRepository channelsRepo;
    private final SignalTypeRepository signalsRepo;
    private final SignalTypeDTOToSignalType signalTypeDTOToSignalType;
    private final SignalTypeToSignalTypeDTO signalTypeToSignalTypeDTO;
    private final ChannelDTOToChannel channelDTOToChannel;
    private final ChannelToChannelDTO channelToChannelDTO;

    public TelevisionServiceImpl(ChannelRepository channelsRepo, SignalTypeRepository signalsRepo, SignalTypeDTOToSignalType signalTypeDTOToSignalType, SignalTypeToSignalTypeDTO signalTypeToSignalTypeDTO, ChannelDTOToChannel channelDTOToChannel, ChannelToChannelDTO channelToChannelDTO) {
        this.channelsRepo = channelsRepo;
        this.signalsRepo = signalsRepo;
        this.signalTypeDTOToSignalType = signalTypeDTOToSignalType;
        this.signalTypeToSignalTypeDTO = signalTypeToSignalTypeDTO;
        this.channelDTOToChannel = channelDTOToChannel;
        this.channelToChannelDTO = channelToChannelDTO;
    }

    public Mono<ChannelDTO> save(ChannelDTO channel){
        Mono<Channel> mono = channelsRepo.save(channelDTOToChannel.convert(channel));
        return Mono.just(channelToChannelDTO.convert(mono));
    }

    @Override
    public Flux<ChannelDTO> findAll() {
        Flux<ChannelDTO> dtos = channelsRepo.findAll().map(i -> channelToChannelDTO.convert(Mono.just(i)));
        return dtos;
    }

    @Override
    public Mono<ChannelDTO> findById(String id) {
        Mono<Channel> mono = channelsRepo.findById(id);
        ChannelDTO channel = channelToChannelDTO.convert(mono);
        return Mono.just(channel);
    }

    @Override
    public Mono<SignalTypeDTO> save(SignalTypeDTO signal) {
        Mono<SignalType> sig = signalsRepo.save(signalTypeDTOToSignalType.convert(signal));
        return Mono.just(signalTypeToSignalTypeDTO.convert(sig));
    }

}
