package org.example.movie.booking.resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.example.movie.booking.dto.BookingInformationDTO;
import org.example.movie.booking.service.MovieBookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class MovieBookingResource {

    private final MovieBookingService movieBookingService;


    @PostMapping("/booking")
    @Operation(summary = "This is to book Movie City")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Schedule retrieved successfully"
//                            ,
//                            content = {
//                                    @Content(
//                                            mediaType = "application/json",
//                                            array = @ArraySchema(schema = @Schema(implementation = Movie.class)))
//                            }
                    ),
                    @ApiResponse(
                            responseCode = "204",
                            description = "No Content Found For Select Criteria",
                            content = @Content),
                    @ApiResponse(
                            responseCode = "404",
                            description = "City Information Not Correct",
                            content = @Content)
            })
    public ResponseEntity bookMovie(@RequestBody BookingInformationDTO bookingInformationDTO)
            throws JsonProcessingException {
        movieBookingService.bookShow(bookingInformationDTO);
        return ResponseEntity.ok().build();
    }
}
