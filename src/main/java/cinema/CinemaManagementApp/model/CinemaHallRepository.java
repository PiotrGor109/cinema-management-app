package cinema.CinemaManagementApp.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CinemaHallRepository extends JpaRepository<CinemaHall, Integer> {

    Page<CinemaHall> findAll(Pageable page);
    Optional<CinemaHall> findById(Integer id);
    CinemaHall save(CinemaHall entity);
    void delete(CinemaHall entity);
    boolean existsById(int id);


}
