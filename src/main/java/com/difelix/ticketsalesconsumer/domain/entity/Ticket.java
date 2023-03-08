package com.difelix.ticketsalesconsumer.domain.entity;

import com.difelix.ticketsalesconsumer.domain.enums.TicketStatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ticket")
public class Ticket {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "value", nullable = false)
  private BigDecimal value;

  @Column(name = "tag", nullable = false, unique = true)
  private String tag;

  @Column(name = "description")
  private String description;

  @Column(name = "quantity_in_stock", nullable = false)
  private int quantityInStock;

  @Builder.Default
  @Column(name = "created_at", nullable = false)
  private Timestamp createdAt = Timestamp.from(Instant.now());

  @Column(name = "updatedAt")
  private Timestamp updatedAt;

  @Enumerated(EnumType.STRING)
  @Column(name = "status", nullable = false)
  private TicketStatusEnum status;
}
