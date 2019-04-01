package com.ggomez.television.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChannelDTO extends ResourceSupport {
    private String channelId;
    private String name;
    private String gridNumber;
    private String description;
    private SignalTypeDTO type;
}
