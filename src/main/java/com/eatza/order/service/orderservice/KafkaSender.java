package com.eatza.order.service.orderservice;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

import com.eatza.order.dto.DeliveryRequestDto;

@Service
public class KafkaSender {

	
	
	@Value("${kafka.topic.name}")
	private  String topicName;
	
	@Autowired
	private  KafkaTemplate<String, DeliveryRequestDto> kafkaTemplate;
	private  final Logger logger = LoggerFactory.getLogger(KafkaSender.class);
	public void publish(DeliveryRequestDto deliveryRequestDto) {
		Map<String, Object> headers = new HashMap<>();
		headers.put(KafkaHeaders.TOPIC, topicName);
		kafkaTemplate.send(new GenericMessage<DeliveryRequestDto>(deliveryRequestDto, headers));
		logger.debug("Message published: with orderId:" + deliveryRequestDto.getOrderId() + " customer id:"
				+ deliveryRequestDto.getCustomerId());
		
	}

}
