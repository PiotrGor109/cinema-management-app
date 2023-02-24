package cinema.CinemaManagementApp.controller;


import cinema.CinemaManagementApp.controller.dto.SeatReadDto;
import cinema.CinemaManagementApp.controller.dto.ShowReadDto;
import cinema.CinemaManagementApp.service.SeatService;
import cinema.CinemaManagementApp.service.ShowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/seats")
public class SeatController {

    private final ApplicationEventPublisher eventPublisher;
    private static final Logger logger = LoggerFactory.getLogger(ShowController.class);
    private final SeatService seatService;

    public SeatController(final ApplicationEventPublisher eventPublisher, final SeatService seatService) {
        this.eventPublisher = eventPublisher;
        this.seatService = seatService;
    }



    //GET METHOD - SEAT
    @GetMapping("/{id}")
    public List<SeatReadDto> getSeatsForShow(@PathVariable int id)
    {
        logger.info("SEATS: SHOW ALL SEATS FOR SHOW WITH ID:" + id+ "- GET METHOD");
        return seatService.readSeats(id);
    }

}
