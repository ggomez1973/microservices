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
public class SignalTypeDTO extends ResourceSupport {
    private String signalTypeId; //_id
    private String description;
}
