package cinema.CinemaManagementApp.controller;

import cinema.CinemaManagementApp.model.Ticket;
import cinema.CinemaManagementApp.service.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final ApplicationEventPublisher eventPublisher;
    private static final Logger logger = LoggerFactory.getLogger(ShowController.class);
    private final TicketService ticketService;

    public TicketController(final ApplicationEventPublisher eventPublisher, final TicketService ticketService) {
        this.eventPublisher = eventPublisher;
        this.ticketService = ticketService;
    }


    //GET METHOD - TICKET
    @GetMapping()
    public List<Ticket> getTicket()
    {
        logger.info("TICKETS: SHOW ALL TICKETS - GET METHOD");
        return ticketService.readAllTickets();
    }


    //POST METHOD - TICKET
    @PostMapping()
    public Ticket postTicket(@RequestBody Ticket ticket)
    {
        return ticketService.addTicket(ticket);
    }



    //DELETE METHOD - TICKET
    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable int id)
    {
        ticketService.deleteTicket(id);
    }




    //PUT METHOD - TICKET
    @PutMapping()
    public void editTicket(@RequestBody Ticket ticket)
    {
        ticketService.editTicket(ticket);
    }


}
