package com.queuesqs.aws.receiver;

import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class MessageReceiver {
	
	
	
	
	@SqsListener(value = "queue-estudos", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
	public void receive(String message) {
		log.info("Menssagem da fila {}", message);
	}


}
