package cinema.CinemaManagementApp.model;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Entity;

import org.springframework.data.relational.core.sql.In;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface SeatRepository extends JpaRepository<Seat, Integer> {


    Page<Seat> findAll(Pageable page);
    Optional<Seat> findById(Integer id);
    Seat save(Seat entity);
    void delete(Seat entity);
    boolean existsById(int id);
   // List<Seat> saveAll(List<Seat> list);


    @Override
    <S extends Seat> List<S> saveAll(Iterable<S> entities);

//    @Transactional
//    @Modifying
//    @Query(value = "DELETE FROM SEATS WHERE show_id LIKE %?1%", nativeQuery = true)
//    void deleteAllSeatsByShowId (int id);

    @Query(value = "SELECT * FROM SEATS WHERE show_id LIKE %?1%", nativeQuery = true)
    List<Seat> findSeatsByShowId (int id);



    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE SEATS SET STATUS='reserved', reservation_id = :reservationId WHERE id IN :id", nativeQuery = true)
    void findSeatsByIdReservation(@Param("id") List<Integer> id, @Param("reservationId") int reservationId);


    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE SEATS SET STATUS='free', reservation_id = null WHERE reservation_id=:reservationId", nativeQuery = true)
    void deleteReservationsFromSeat(@Param("reservationId") int id);





}







