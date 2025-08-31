/* TicketFactory.java
     TicketFactory class
     Author: S Rawoot (221075127)
     Date: 18 May 2025 */
package za.ac.cput.factory;

import za.ac.cput.domain.*;
import za.ac.cput.util.Helper;

public class TicketFactory {
    public static Ticket createTicket(String ticketId, Customer user, Payment payment, Schedule schedule, Seat seat) {

        if (Helper.isNullOrEmpty(ticketId)) {
            return null;
        }

        return new Ticket.Builder()
                .setTicketId(ticketId)
                .setUser(user)
                .setPayment(payment)
                .setSchedule(schedule)
                .setSeat(seat)
                .build();
    }
}
