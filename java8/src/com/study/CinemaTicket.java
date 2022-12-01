package com.study;

public class CinemaTicket {
	private int ticketNumber = 10;

	public void bookTicket(String name, int ticketCount) {
		synchronized (this) {
			if (ticketNumber >= ticketCount && ticketCount > 0) {
				ticketNumber -= ticketCount;
				System.out.printf("%s bought %d tickets.%n", new Object[] { name, ticketCount });
			} else {
				System.out.println("Sufficient Ticket Not Available.");
			}
		}

	}
}
