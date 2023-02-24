package cinema.CinemaManagementApp.controller;

import cinema.CinemaManagementApp.controller.dto.CinemaHallDto;
import cinema.CinemaManagementApp.model.CinemaHall;
import cinema.CinemaManagementApp.service.CinemaHallService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinemahalls")
public class CinemaHallController {

    private final ApplicationEventPublisher eventPublisher;
    private static final Logger logger = LoggerFactory.getLogger(TicketController.class);
    private final CinemaHallService cinemaHallService;

    public CinemaHallController(final ApplicationEventPublisher eventPublisher, final CinemaHallService cinemaHallService) {
        this.eventPublisher = eventPublisher;
        this.cinemaHallService = cinemaHallService;
    }


    //GET METHOD - CINEMA HALL
    @GetMapping()
    public List<CinemaHallDto> getCinemaHall()
    {
        return cinemaHallService.readAllCinemaHall();
    }



    //POST METHOD - CINEMA HALL
    @PostMapping()
    public CinemaHall postCinemaHall(@RequestBody CinemaHall cinemahall)
    {
        return cinemaHallService.addCinemaHall(cinemahall);
    }



    //DELETE METHOD - CINEMA HALL
    @DeleteMapping("/{id}")
    public void deleteCinemaHall(@PathVariable int id)
    {
        cinemaHallService.deleteCinemaHall(id);
    }




    //PUT METHOD - CINEMA HALL
    @PutMapping()
    public void editCinemaHall(@RequestBody CinemaHall cinemahall)
    {
        cinemaHallService.editCinemaHall(cinemahall);
    }


}
