package com.joseneyra.sfmsbreweryclient.web.client;

import com.joseneyra.sfmsbreweryclient.web.model.BeerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)    // Looks into the application.properties file and grabs the properties under "sfg.brewery". IgnoreUnknownField will make this failed if the property is not set
public class BreweryClient {

    public final String BEER_PATH_V1 = "/api/v1/beer/";
    private String apihost;     // Comes from the applications.properties

    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID uuid) {
        return restTemplate.getForObject(apihost + BEER_PATH_V1 + uuid.toString(), BeerDto.class);
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }
}
