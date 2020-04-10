package com.airplane.vja.ticket.entity;

import java.util.List;

public class Ticket {
    private List<Object> tickets;
 
    public Ticket( List<Object> tickets) {
        this.tickets = tickets;
    }

  
    public Ticket() {
    	
    }
    public List<Object> gettickets() {
        return tickets;
    }

    public void setTickets(List<Object> tickets) {
        this.tickets = tickets;
    }
 
}
