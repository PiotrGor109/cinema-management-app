package cinema.CinemaManagementApp.model;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    Page<Ticket> findAll(Pageable page);
    Ticket save(Ticket entity);
    void delete(Ticket entity);
    boolean existsById(int id);
    Optional<Ticket> findById(int id);
}