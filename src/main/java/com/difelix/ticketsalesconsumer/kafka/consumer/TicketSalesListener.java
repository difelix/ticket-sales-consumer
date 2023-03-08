package com.difelix.ticketsalesconsumer.kafka.consumer;

import com.difelix.ticketsalesconsumer.domain.entity.Purchase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class TicketSalesListener {

  @KafkaListener(topics = "ticket-sales", groupId = "group_id")
  public void consume(ConsumerRecord<String, Purchase> payload) {
    Purchase purchase = payload.value();

    log.info("Customer name: " + purchase.getCustomer().getName());
    log.info("Ticket tag: " + purchase.getTicket().getTag());
  }
}
