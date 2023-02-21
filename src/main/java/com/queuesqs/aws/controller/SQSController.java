package com.queuesqs.aws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SQSController {

	@Value("cloud.aws.end-point.url")
	private String sqsUrl;

	@Autowired
	private final QueueMessagingTemplate queueMessagingTemplate;

	public SQSController(QueueMessagingTemplate queueMessagingTemplate) {
		this.queueMessagingTemplate = queueMessagingTemplate;
	}

	@GetMapping("/push/{msg}")
	public void pushMessage(@PathVariable("msg") String msg) {
		queueMessagingTemplate.send(sqsUrl, MessageBuilder.withPayload(msg).build());

	}

}
