package com.queuesqs.aws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SQSController {

	@Value("${cloud.aws.end-point.uri}")
	private String sqsUrl;

	@Autowired
	private final QueueMessagingTemplate queueMessagingTemplate;

	public SQSController(QueueMessagingTemplate queueMessagingTemplate) {
		this.queueMessagingTemplate = queueMessagingTemplate;
	}

	@GetMapping("/send/{msg}")
	public void send(@PathVariable("msg") String msg) {
		queueMessagingTemplate.send(sqsUrl, MessageBuilder.withPayload(msg).build());

	}


}
