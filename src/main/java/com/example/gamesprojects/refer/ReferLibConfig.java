package com.example.gamesprojects.refer;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Getter
@Setter
@Component
public class ReferLibConfig {
    @Value("${referlib.api.endpoint}")
    private String referLibApiEndpoint;

    @Value("${referlib.header.host}")
    private String referLibHeaderHost;

    @Value("${referlib.host}")
    private String referLibHost;

    @Value("${referlib.header.key}")
    private String referLibHeaderKey;

    @Value("${referlib.key}")
    private String referLibKey;
}


