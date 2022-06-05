package com.example.gamesprojects.refer;

import com.example.gamesprojects.domain.dto.ReferLibraryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpHeaders;
import java.util.*;

@Component
@RequiredArgsConstructor
public class ReferLibClient {

    private final RestTemplate restTemplate;
    private final ReferLibConfig referLibConfig;

    public List<ReferLibraryDto> getRandomRefer() {

        final HttpHeaders headers = new HttpHeaders();
        headers.add(referLibConfig.getReferLibHeaderHost(), referLibConfig.getReferLibHost());
        headers.add(referLibConfig.getReferLibHeaderKey(), referLibConfig.getReferLibKey());

        final HttpEntity<String> entity = new HttpEntity<>(headers);

        ReferLibraryDto[] response = restTemplate.exchange(referLibConfig.getReferLibApiEndpoint(), HttpMethod.GET, entity, ReferLibraryDto[].class).getBody();

        try {
            return Optional.ofNullable(response)
                    .map(Arrays::asList)
                    .orElse(Collections.emptyList());
        } catch (RestClientException e) {
            return new ArrayList<>();
        }
    }

}
