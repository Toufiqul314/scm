package com.scm.helper;

import lombok.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    private String content;
    @Builder.Default
    private MessageType type=MessageType.blue;
}
