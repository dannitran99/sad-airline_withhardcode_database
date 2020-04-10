package com.airplane.vna.ticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airplane.vna.ticket.entity.Ticket;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController {
	@Autowired
	private Environment env;

	@RequestMapping("/")
	public String home() {
		// This is useful for debugging
		// When having multiple instance of image service running at different ports.
		// We load balance among them, and display which instance received the request.
		return "Hello from Image Service running at port: " + env.getProperty("local.server.port");
	}
		
	@RequestMapping("/ticket")
	public List<Ticket> getTicket() {
		List<Ticket> ticket = Arrays.asList(
			new Ticket(1, 3000000, "BinhThuan","HaNoi","adult",1600423,3,"A"),
			new Ticket(2, 3700000, "BinhThuan","HaNoi","adult",30042020,6,"A"),
			new Ticket(3, 3400000, "HaNoi","BinhThuan","adult",1052020,12,"A"),
			new Ticket(3, 2500000, "BinhDuong","LongAn","adult",1213521,5,"A")
			);
		return ticket;
	}
}