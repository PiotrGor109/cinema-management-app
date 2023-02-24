package cinema.CinemaManagementApp.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShowRepository extends JpaRepository<Show, Integer> {

    Page<Show> findAll(Pageable page);
    Optional<Show> findById(Integer id);
    Show save(Show entity);
    void delete(Show entity);
    boolean existsById(Show id);

}