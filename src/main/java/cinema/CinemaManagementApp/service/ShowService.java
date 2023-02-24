package cinema.CinemaManagementApp.service;

import cinema.CinemaManagementApp.controller.ShowController;
import cinema.CinemaManagementApp.controller.dto.ShowReadDto;
import cinema.CinemaManagementApp.model.*;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShowService {


    private final ShowRepository showRepository;
    private final SeatRepository seatRepository;
    private static final Logger logger = LoggerFactory.getLogger(ShowController.class);


    public ShowService(final ShowRepository showRepository, final SeatRepository seatRepository) {
        this.showRepository = showRepository;
        this.seatRepository = seatRepository;
    }




    //GET SHOWS
    public List<ShowReadDto> readAllShows() {
        logger.info("READ ALL SHOWS");
        return showRepository.findAll().stream().map(show -> ShowReadDto.ShowReadDtoBuilder.aShowReadDto()
                .withId(show.getId())
                .withTitle(show.getTitle())
                .withDateTime(show.getDateTime())
                .withDurationTime(show.getDurationTime())
                .withImagePath(show.getImagePath())
                .withMovieType(show.getMovieType())
                .withCinemaHall(show.getCinemaHall().getId(), show.getCinemaHall().getNumberOfPlaces())
                .build()
        ).collect(Collectors.toList());
    }





    //POST SHOWS
    @Transactional
    public Show addShow(ShowReadDto show) {
        CinemaHall cinemaHallToAssign = new CinemaHall();
        cinemaHallToAssign.setId(show.getCinemaHall().getId());
        cinemaHallToAssign.setNumberOfPlaces(show.getCinemaHall().getNumberOfPlaces());
        Show newShow = new Show();
        newShow.setId(show.getId());



        int numberOfPlaces = show.getCinemaHall().getNumberOfPlaces();
        logger.info("NUMBEROFPLACES: "+numberOfPlaces);
        List<Seat> seatList = new ArrayList<>();
        for (int i = 0; i < numberOfPlaces; i++) {
            Seat newSeat = new Seat();
            newSeat.setStatus("free");
            newSeat.setShow(newShow);
            newSeat.setSeatNumber(i+1);
            seatList.add(newSeat);
        }
        seatRepository.saveAll(seatList);

        newShow.setDateTime(show.getDateTime());
        newShow.setDurationTime(show.getDurationTime());
        newShow.setImagePath(show.getImagePath());
        newShow.setTitle(show.getTitle());
        newShow.setMovieType(show.getMovieType());
        newShow.setCinemaHall(cinemaHallToAssign);

        logger.info("NUMBEROFPLACES2: "+cinemaHallToAssign.getNumberOfPlaces());

        return showRepository.save(newShow);
    }



    //DELETE - delete Show
    public void deleteShow(int id) {
        logger.info("DELETE SHOW");
       // seatRepository.deleteAllSeatsByShowId(id);
        Show showToDelete = showRepository.findById(id).orElseThrow(null);
        showRepository.delete(showToDelete);
    }


    //PUT - edit Show
    public Show editShow(@RequestBody Show newShow) {
        logger.info("EDIT SHOW");
        return showRepository.save(newShow);
    }


}
