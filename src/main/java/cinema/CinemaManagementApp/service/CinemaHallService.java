package cinema.CinemaManagementApp.service;

import cinema.CinemaManagementApp.controller.CinemaHallController;
import cinema.CinemaManagementApp.controller.dto.CinemaHallDto;
import cinema.CinemaManagementApp.model.CinemaHall;
import cinema.CinemaManagementApp.model.CinemaHallRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CinemaHallService {


    private final CinemaHallRepository cinemaHallRepository;
    private static final Logger logger = LoggerFactory.getLogger(CinemaHallController.class);


    public CinemaHallService(final CinemaHallRepository cinemaHallRepository) {
        this.cinemaHallRepository = cinemaHallRepository;
    }


    public List<CinemaHallDto> readAllCinemaHall()
    {
        return cinemaHallRepository.findAll().stream().map(cinemaHall -> CinemaHallDto.CinemaHallDtoBuilder.aCinemaHallDto()
        .withId(cinemaHall.getId())
        .withNumberOfPlaces(cinemaHall.getNumberOfPlaces()).build()
        ).collect(Collectors.toList());
    }



    //POST - add CinemaHall
    public CinemaHall addCinemaHall(@RequestBody CinemaHall newHall) {
        return cinemaHallRepository.save(newHall);
    }



    //PUT - edit CinemaHall
    public CinemaHall editCinemaHall(@RequestBody CinemaHall newHall) {
        return cinemaHallRepository.save(newHall);
    }



    //DELETE - delete CinemaHall
    public void deleteCinemaHall(int id) {
        CinemaHall cinemaHallToDelete = cinemaHallRepository.findById(id).orElseThrow(null);
        cinemaHallRepository.delete(cinemaHallToDelete);
    }






}
