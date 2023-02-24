package cinema.CinemaManagementApp.service;

import cinema.CinemaManagementApp.controller.TicketController;
import cinema.CinemaManagementApp.model.Ticket;
import cinema.CinemaManagementApp.model.TicketRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TicketService {



    private final TicketRepository ticketRepository;
    private static final Logger logger = LoggerFactory.getLogger(TicketController.class);


    public TicketService(final TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }



    public List<Ticket> readAllTickets() {
        logger.info("READ ALL TICKETS");
        return ticketRepository.findAll();
    }


    //POST - add Ticket
    public Ticket addTicket(@RequestBody Ticket newTicket) {
        return ticketRepository.save(newTicket);
    }



    //PUT - edit Ticket
    public Ticket editTicket(@RequestBody Ticket newTicket) {
        return ticketRepository.save(newTicket);
    }



    //DELETE - delete Ticket
    public void deleteTicket(int id) {
        Ticket ticketToDelete = ticketRepository.findById(id).orElseThrow(null);
        ticketRepository.delete(ticketToDelete);
    }

}
