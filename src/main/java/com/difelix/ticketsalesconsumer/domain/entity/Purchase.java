package com.difelix.ticketsalesconsumer.domain.entity;

import com.difelix.ticketsalesconsumer.domain.enums.PurchaseStatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;
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
@Table(name = "purchase")
public class Purchase {

  @Id
  private String id;

  @OneToOne
  @JoinColumn(name = "customer_id")
  private Customer customer;

  @OneToOne
  @JoinColumn(name = "ticket_id")
  private Ticket ticket;

  @Column(name = "amount", nullable = false)
  private int amount;

  @Column(name = "total_amount_payable", nullable = false)
  private BigDecimal totalAmountPayable;

  @Enumerated(EnumType.STRING)
  @Column(name = "status", nullable = false)
  private PurchaseStatusEnum status;

  @Column(name = "purchase_date", nullable = false)
  private Timestamp purchaseDate;
}
