CREATE TABLE IF NOT EXISTS purchase (
  id VARCHAR(100),
  customer_id BIGINT,
  ticket_id BIGINT,
  amount INTEGER NOT NULL,
  total_amount_payable NUMERIC(5,2) NOT NULL,
  status VARCHAR(50) DEFAULT 'PROCESSING',
  purchase_date TIMESTAMP DEFAULT NOW(),
  CONSTRAINT fk_customer FOREIGN KEY(customer_id) REFERENCES customer(id),
  CONSTRAINT fk_ticket FOREIGN KEY(ticket_id) REFERENCES ticket(id)
);