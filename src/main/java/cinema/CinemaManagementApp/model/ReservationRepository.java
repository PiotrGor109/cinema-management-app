package cinema.CinemaManagementApp.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    Page<Reservation> findAll(Pageable page);
    Optional<Reservation> findById(Integer id);
    Reservation save(Reservation entity);
    void delete(Reservation entity);
    boolean existsById(int id);



}
