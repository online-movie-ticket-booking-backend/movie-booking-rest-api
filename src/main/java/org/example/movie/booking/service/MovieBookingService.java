package org.example.movie.booking.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.example.movie.booking.command.BookTicketCommand;
import org.example.movie.booking.dto.BookingInformationDTO;
import org.example.movie.core.common.booking.BookingInformation;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class MovieBookingService {

    private final CommandGateway commandGateway;

    public void bookShow(BookingInformationDTO bookingInformationDTO) {
        String uniqueId = UUID.randomUUID().toString();
        BookingInformation bookingInformation = BookingInformation.of();
        BeanUtils.copyProperties(bookingInformationDTO, bookingInformation);
        log.info("Starting operation with id : {}", uniqueId);
        commandGateway.send(BookTicketCommand.of()
                .setUniqueId(uniqueId)
                .setBookingInformation(bookingInformation));
    }

}
