package org.example.example.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class PostModel {
    private final String login;
    private final String password;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime date;


}

//lombook
//загуглить почему графиик не работают
// посмотреть что за метрики + добавить в конфинг телеграфа

