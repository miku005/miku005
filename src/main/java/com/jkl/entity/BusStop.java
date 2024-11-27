package com.jkl.entity;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bus_stop")
public class BusStop {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private long id;

	@ManyToOne
	@JoinColumn(name="bus_id")
	private Bus bus;
	
	@ManyToOne
	@JoinColumn(name="stop_id")
	private Stop stop;
	
	@Column(name = "order_number",nullable = false)
	private Integer orderNumber;
	
	@Column(name = "departure_time",nullable = false)
	private LocalTime departureTime;
}
