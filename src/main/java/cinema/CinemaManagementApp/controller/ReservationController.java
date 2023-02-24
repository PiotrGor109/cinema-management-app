package cinema.CinemaManagementApp.controller;


import cinema.CinemaManagementApp.controller.dto.ReservationDto;
import cinema.CinemaManagementApp.model.Reservation;
import cinema.CinemaManagementApp.service.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ApplicationEventPublisher eventPublisher;
    private static final Logger logger = LoggerFactory.getLogger(TicketController.class);
    private final ReservationService reservationService;

    public ReservationController(final ApplicationEventPublisher eventPublisher, final ReservationService reservationService) {
        this.eventPublisher = eventPublisher;
        this.reservationService = reservationService;
    }


    //GET METHOD - RESERVATION - SMALL
    @GetMapping()
    public List<ReservationDto> getReservations()
    {
        return reservationService.readAllReservations();
    }



    //POST METHOD - RESERVATIONS - SMALL
    @PostMapping()
    public Reservation postReservation(@RequestBody ReservationDto reservation)
    {
        return reservationService.addReservation(reservation);
    }



    //DELETE METHOD - RESERVATIONS - SMALL
    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable int id)
    {
        reservationService.deleteReservation(id);
    }



    //PUT METHOD - SHOW - SMALL
    @PutMapping()
    public void editReservation(@RequestBody Reservation reservation)
    {
        reservationService.editReservation(reservation);
    }



}
