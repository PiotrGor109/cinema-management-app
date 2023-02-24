package cinema.CinemaManagementApp.controller.dto;

import cinema.CinemaManagementApp.controller.ShowController;
import cinema.CinemaManagementApp.model.CinemaHall;
import cinema.CinemaManagementApp.model.Seat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ShowReadDto {

    private int id;
    private String title;
    private double durationTime;
    private String movieType;
    private String imagePath;
    private LocalDateTime dateTime;
    private CinemaHallDto cinemaHall;
    //private List<SeatReadDto> seats;
    private static final Logger logger = LoggerFactory.getLogger(ShowController.class);


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(double durationTime) {
        this.durationTime = durationTime;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public CinemaHallDto getCinemaHall() {
        return cinemaHall;
    }

    public void setCinemaHall(CinemaHallDto cinemaHall) {
        this.cinemaHall = cinemaHall;
    }

//    public List<SeatReadDto> getSeats() {
//        return seats;
//    }
//
//    public void setSeats(List<SeatReadDto> seats) {
//        this.seats = seats;
//    }

    public static Logger getLogger() {
        return logger;
    }




    public static final class ShowReadDtoBuilder {
        private int id;
        private String title;
        private double durationTime;
        private String movieType;
        private String imagePath;
        private LocalDateTime dateTime;
        private CinemaHallDto cinemaHall;
      //  private List<SeatReadDto> seats;


        public ShowReadDtoBuilder() {
        }

        public static ShowReadDto.ShowReadDtoBuilder aShowReadDto() {
            return new ShowReadDto.ShowReadDtoBuilder();
        }

        public ShowReadDto.ShowReadDtoBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public ShowReadDto.ShowReadDtoBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public ShowReadDto.ShowReadDtoBuilder withDurationTime(double durationTime) {
            this.durationTime = durationTime;
            return this;
        }

        public ShowReadDto.ShowReadDtoBuilder withMovieType(String movieType) {
            this.movieType = movieType;
            return this;
        }

        public ShowReadDto.ShowReadDtoBuilder withImagePath(String imagePath) {
            this.imagePath = imagePath;
            return this;
        }

        public ShowReadDto.ShowReadDtoBuilder withDateTime(LocalDateTime dateTime) {
            this.dateTime = dateTime;
            return this;
        }


        public ShowReadDto.ShowReadDtoBuilder withCinemaHall(int id, int numberOfPlaces) {
            CinemaHallDto cinemaHallDto = new CinemaHallDto();
            cinemaHallDto.setId(id);
            cinemaHallDto.setNumberOfPlaces(numberOfPlaces);
            this.cinemaHall = cinemaHallDto;
            return this;
        }

//        public ShowReadDtoBuilder withPlaces(List<SeatReadDto> seats) {
//            this.seats = seats;
//            return this;
//        }


        public ShowReadDto build() {
            ShowReadDto ShowReadDto = new ShowReadDto();
            ShowReadDto.title = this.title;
            ShowReadDto.id = this.id;
            ShowReadDto.durationTime = this.durationTime;
            ShowReadDto.movieType = this.movieType;
            ShowReadDto.imagePath = this.imagePath;
            ShowReadDto.dateTime = this.dateTime;
            ShowReadDto.cinemaHall=this.cinemaHall;
            //ShowReadDto.seats=this.seats;
            return ShowReadDto;
        }
    }
}

