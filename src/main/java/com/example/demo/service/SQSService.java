package com.example.demo.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SQSService {

    private final AmazonSQS sqs;
    private final String queueName;

    @Autowired
    public SQSService(AmazonSQS sqs, @Value("${aws.sqs.queue-name}") String queueName) {
        this.sqs = sqs;
        this.queueName = queueName;
    }

    public void sendMessage(String message) {
        System.out.println("Message is " + message);
        SendMessageRequest request =
            new SendMessageRequest(sqs.getQueueUrl(queueName).getQueueUrl(), message);
        sqs.sendMessage(request);
    }

}
