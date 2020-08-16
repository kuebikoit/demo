package com.example.demo.config;

import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class SQSConfiguration {

    @Bean
    @Profile("local")
    public AmazonSQS sqs(@Value("${aws.local.endpoint}") String localEndpoint,
        @Value("${aws.local.region}") String localRegion) {

        System.out.println("Building sqs");

        return AmazonSQSClientBuilder.standard()
            .withEndpointConfiguration(new EndpointConfiguration(localEndpoint, localRegion))
            .build();
    }

    @Bean
    @Profile("!local")
    public AmazonSQS sqs() {
        return AmazonSQSClientBuilder.standard().build();
    }

}
