package com.ggomez.television.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Channel {
    @Id
    private String channelId;
    private String name;
    private String gridNumber;
    private String description;
    private SignalType type;
}
