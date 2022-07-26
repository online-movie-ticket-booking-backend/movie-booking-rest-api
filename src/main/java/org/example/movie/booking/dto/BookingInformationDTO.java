package org.example.movie.booking.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingInformationDTO {
    private String movieId;
    private String cityId;
    private String userUniqueIdentification;
    private LocalDateTime movieDateTime;
    private String theatreId;
    private String scheduleUniqueId;
    private int numberOfSeat;
}
