package za.ac.cput.domain;

import org.springframework.scheduling.annotation.Scheduled;

public class Ticket {
    private String ticketId;
    private User user;
    private Payment payment;
    private Schedule schedule;
    private Seat seat;

    protected Ticket() {
    }

    private Ticket(Builder builder) {
        this.ticketId = builder.ticketId;
        this.user = builder.user;
        this.payment = builder.payment;
        this.schedule = builder.schedule;
        this.seat = builder.seat;
    }

    public String getTicketId() {
        return ticketId;
    }

    public User getUser() {
        return user;
    }

    public Payment getPayment() {
        return payment;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public Seat getSeat() {
        return seat;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", user=" + user +
                ", payment=" + payment +
                ", schedule=" + schedule +
                ", seat=" + seat +
                '}';
    }

    public static class Builder {
        private String ticketId;
        private User user;
        private Payment payment;
        private Schedule schedule;
        private Seat seat;

        public Builder setTicketId(String ticketId) {
            this.ticketId = ticketId;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder setPayment(Payment payment) {
            this.payment = payment;
            return this;
        }

        public Builder setSchedule(Schedule schedule) {
            this.schedule = schedule;
            return this;
        }

        public Builder setSeat(Seat seat) {
            this.seat = seat;
            return this;
        }

        public Builder copy(Ticket ticket) {
            this.ticketId = ticket.ticketId;
            this.user = ticket.user;
            this.payment = ticket.payment;
            this.schedule = ticket.schedule;
            this.seat = ticket.seat;
            return this;
        }

        public Ticket build() {
            return new Ticket(this);
        }
    }
}
