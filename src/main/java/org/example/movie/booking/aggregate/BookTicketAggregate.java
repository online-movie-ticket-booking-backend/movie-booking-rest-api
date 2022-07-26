package org.example.movie.booking.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.example.movie.booking.command.BookTicketCommand;
import org.example.movie.booking.event.BookTicketEvent;
import org.example.movie.core.common.booking.BookingInformation;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Aggregate
@Component
public class BookTicketAggregate {
    @AggregateIdentifier
    private String uniqueId;

    public BookTicketAggregate() {
    }

    @CommandHandler
    public BookTicketAggregate(BookTicketCommand bookTicketCommand) {
        BookingInformation bookingInformation = BookingInformation.of();
        BeanUtils.copyProperties(bookTicketCommand.getBookingInformation(), bookingInformation);
        AggregateLifecycle.apply(BookTicketEvent
                .of()
                .setUniqueId(bookTicketCommand.getUniqueId())
                .setBookingInformation(bookingInformation)
        );
    }

    @EventSourcingHandler
    public void on(BookTicketEvent bookTicketEvent) {
        this.uniqueId = bookTicketEvent.getUniqueId();
    }
}
