package com.airplane.vna.ticket.entity;

import java.util.List;

public class Booking {
    private List<Object> tickets;
 
    public Booking( List<Object> tickets) {
        this.tickets = tickets;
    }

  
    public Booking() {
    	
    }
    public List<Object> gettickets() {
        return tickets;
    }

    public void setTickets(List<Object> tickets) {
        this.tickets = tickets;
    }
 
}
