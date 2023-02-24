package cinema.CinemaManagementApp.controller;

import cinema.CinemaManagementApp.controller.dto.ShowReadDto;
import cinema.CinemaManagementApp.model.Show;
import cinema.CinemaManagementApp.service.ShowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shows")
public class ShowController {

    private final ApplicationEventPublisher eventPublisher;
    private static final Logger logger = LoggerFactory.getLogger(ShowController.class);
    private final ShowService showService;

    public ShowController(final ApplicationEventPublisher eventPublisher, final ShowService showService) {
        this.eventPublisher = eventPublisher;
        this.showService = showService;
    }


    //GET METHOD - SHOW
    @GetMapping()
    public List<ShowReadDto> getShow()
    {
        logger.info("SHOWS: SHOW ALL SHOWS - GET METHOD");
        return showService.readAllShows();
    }

    //POST METHOD - SHOW
    @PostMapping()
    public Show postShow(@RequestBody ShowReadDto show)
    {
        logger.info("ADD SHOW");
        return showService.addShow(show);
    }



    //DELETE METHOD - SHOW
    @DeleteMapping("/{id}")
    public void deleteShow(@PathVariable int id)
    {
        showService.deleteShow(id);
    }


    //PUT METHOD - SHOW
    @PutMapping()
    public void editShow(@RequestBody Show show)
    {
        showService.editShow(show);
    }



}

