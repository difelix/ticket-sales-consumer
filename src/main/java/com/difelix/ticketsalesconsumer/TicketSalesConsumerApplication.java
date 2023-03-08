package com.difelix.ticketsalesconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class TicketSalesConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketSalesConsumerApplication.class, args);
	}

}
