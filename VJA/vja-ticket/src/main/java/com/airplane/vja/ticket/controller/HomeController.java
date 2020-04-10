package com.airplane.vja.ticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airplane.vja.ticket.entity.Ticket;

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
			new Ticket(1, 3000000, "BinhThuan","HaNoi","adult",30042020,6,"A"),
			new Ticket(4, 3000000, "HaNoi","BinhThuan","adult",1052020,12,"A"),
			new Ticket(2, 3500000, "BinhDuong","NhaTrang","adult",1600223,5,"A"),
			new Ticket(3, 4000000, "HCM","HaNoi","adult",1600423,7,"C"),
			new Ticket(5, 3500000, "BinhThuan","HaNoi","adult",30042020,2,"A")
			);
		return ticket;
	}
}