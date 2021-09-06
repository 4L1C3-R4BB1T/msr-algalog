package com.algaworks.algalog.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.algaworks.algalog.domain.model.DeliveryStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryModel {

	private Long id;
	private String clientName;
	private ClientSummaryModel client;
	private ReceiverModel receiver;
	private BigDecimal tax;
	private DeliveryStatus status;
	private OffsetDateTime requestDate;
	private OffsetDateTime completionDate;
	
}
