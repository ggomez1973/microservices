package com.ggomez.television.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.hateoas.ResourceSupport;

@Data
@Document
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Channel extends ResourceSupport {
    @Id
    private String codigo;
    private SignalType signalType;
    private String name;
    private String gridNumber;
    private String description;

    @JsonCreator

    public Channel(@JsonProperty("codigo") String codigo) {
        this.codigo = codigo;
    }
}
