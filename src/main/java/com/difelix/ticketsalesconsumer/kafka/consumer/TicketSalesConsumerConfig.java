package com.difelix.ticketsalesconsumer.kafka.consumer;

import com.difelix.ticketsalesconsumer.domain.entity.Purchase;
import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@EnableKafka
@Configuration
public class TicketSalesConsumerConfig {

  @Value("${spring.kafka.consumer.bootstrap-servers}")
  private String bootstrapServer;

  @Value("${spring.kafka.consumer.group-id}")
  private String groupId;

  @Bean
  public ConsumerFactory<String, Purchase> purchaseConsumerFactory() {
    Map<String, Object> configProps = new HashMap<>();

    configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
    configProps.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
    configProps.put(JsonDeserializer.USE_TYPE_INFO_HEADERS, false);
    configProps.put(JsonDeserializer.TRUSTED_PACKAGES, "com.difelix.ticketsalesconsumer");

    return new DefaultKafkaConsumerFactory<>(
        configProps, new StringDeserializer(), new JsonDeserializer<>(Purchase.class));
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, Purchase> kafkaListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory<String, Purchase> factory =
        new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(purchaseConsumerFactory());
    return factory;
  }
}
