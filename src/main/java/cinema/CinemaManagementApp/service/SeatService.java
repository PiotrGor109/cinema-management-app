package cinema.CinemaManagementApp.service;

import cinema.CinemaManagementApp.controller.ShowController;
import cinema.CinemaManagementApp.controller.dto.SeatReadDto;
import cinema.CinemaManagementApp.model.SeatRepository;
import cinema.CinemaManagementApp.model.ShowRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeatService {

    private final SeatRepository seatRepository;
    private static final Logger logger = LoggerFactory.getLogger(ShowController.class);


    public SeatService(final SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }





    public List<SeatReadDto> readSeats(int id) {
        return seatRepository.findSeatsByShowId(id).stream().map(seat -> SeatReadDto.SeatReadDtoBuilder.aSeatReadDto()
        .withId(seat.getId())
        .withSeatNumber(seat.getSeatNumber())
        .withStatus(seat.getStatus())
                .withShowId(seat.getShow())
                .withShowTitle(seat.getShow())
                .withDateTime(seat.getShow())
        .build()).collect(Collectors.toList());
    }
}
