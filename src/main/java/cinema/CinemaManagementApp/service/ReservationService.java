package cinema.CinemaManagementApp.service;

import cinema.CinemaManagementApp.controller.CinemaHallController;
import cinema.CinemaManagementApp.controller.dto.CinemaHallDto;
import cinema.CinemaManagementApp.controller.dto.ReservationDto;
import cinema.CinemaManagementApp.controller.dto.SeatReadDto;
import cinema.CinemaManagementApp.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final SeatRepository seatRepository;
    private static final Logger logger = LoggerFactory.getLogger(CinemaHallController.class);


    public ReservationService(final ReservationRepository reservationRepository, final SeatRepository seatRepository) {
        this.reservationRepository = reservationRepository;
        this.seatRepository = seatRepository;
    }



    public List<ReservationDto> readAllReservations() {
        return reservationRepository.findAll().stream().map(reservation -> ReservationDto.ReservationDtoBuilder.aReservationDto()
        .withCustomerName(reservation.getCustomerName())
        .withCustomerPhone(reservation.getCustomerPhone())
        .withId(reservation.getId())
        .withSeatReadDto(reservation.getSeats().stream().map(seat -> SeatReadDto.SeatReadDtoBuilder.aSeatReadDto()
        .withId(seat.getId())
        .withSeatNumber(seat.getSeatNumber())
        .withStatus(seat.getStatus())
                .withDateTime(seat.getShow())
                .withShowId(seat.getShow())
                .withShowTitle(seat.getShow())
        .build()).collect(Collectors.toList()))
                        .build()
        ).collect(Collectors.toList());
    }


    @Transactional
    public void deleteReservation(int id) {
        logger.info("DELETE RESERVATIONS WITH ID: "+id);
        seatRepository.deleteReservationsFromSeat(id);
        Reservation reservationToDelete = reservationRepository.findById(id).orElseThrow(null);
        reservationRepository.delete(reservationToDelete);
    }



    public Reservation editReservation(@RequestBody Reservation newReservation) {
        logger.info("EDIT RESERVATION");
        return reservationRepository.save(newReservation);
    }


    @Transactional
    public Reservation addReservation(ReservationDto reservation) {
        logger.info("ADD RESERVATION");

        List<Integer> idOfSeats = new ArrayList<>();
        for(int i=0; i<reservation.getSeats().size(); i++)
        {
            int idSeat = reservation.getSeats().get(i).getId();
            idOfSeats.add(idSeat);
        }
       logger.info("AAAAAAAAAAAAAAAAA: "+idOfSeats);
        Reservation reservationNew = new Reservation();
        reservationNew.setCustomerName(reservation.getCustomerName());
        reservationNew.setCustomerPhone(reservation.getCustomerPhone());
        reservationNew.setId(reservation.getId());

        Reservation newAddedReservation = reservationRepository.save(reservationNew);
        seatRepository.findSeatsByIdReservation(idOfSeats, newAddedReservation.getId());
        return reservationNew;

    }
}








