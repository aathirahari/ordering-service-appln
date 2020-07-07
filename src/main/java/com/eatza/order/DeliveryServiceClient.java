package com.eatza.order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.eatza.order.dto.DeliveryRequestDto;

@FeignClient(name="DELIVERY-SERVICE")
public interface DeliveryServiceClient {
@PostMapping("/delivery")
String assignDeliveryPerson(DeliveryRequestDto deliveryRequestDto);
}
