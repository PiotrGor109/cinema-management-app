package cinema.CinemaManagementApp.controller.dto;


import cinema.CinemaManagementApp.model.Show;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class SeatReadDto {


    private int id;
    private int seatNumber;
    private String status;
    private int showId;
    private String showTitle;
    private LocalDateTime showDateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public LocalDateTime getShowDateTime() {
        return showDateTime;
    }

    public void setShowDateTime(LocalDateTime showDateTime) {
        this.showDateTime = showDateTime;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public String getShowTitle() {
        return showTitle;
    }

    public void setShowTitle(String showTitle) {
        this.showTitle = showTitle;
    }

    public static final class SeatReadDtoBuilder {
        private int id;
        private int seatNumber;
        private String status;
        private int showId;
        private String showTitle;
        private LocalDateTime showDateTime;

        public SeatReadDtoBuilder() {
        }

        public static SeatReadDto.SeatReadDtoBuilder aSeatReadDto() {
            return new SeatReadDto.SeatReadDtoBuilder();
        }

        public SeatReadDto.SeatReadDtoBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public SeatReadDto.SeatReadDtoBuilder withSeatNumber(int seatNumber) {
            this.seatNumber = seatNumber;
            return this;
        }

        public SeatReadDto.SeatReadDtoBuilder withStatus(String status) {
            this.status = status;
            return this;
        }

        public SeatReadDto.SeatReadDtoBuilder withShowId(Show show) {
            this.showId = show.getId();
            return this;
        }

        public SeatReadDto.SeatReadDtoBuilder withShowTitle(Show show) {
            this.showTitle = show.getTitle();
            return this;
        }

        public SeatReadDto.SeatReadDtoBuilder withDateTime(Show show) {
            this.showDateTime = show.getDateTime();
            return this;
        }



        public SeatReadDto build() {
            SeatReadDto seatDto = new SeatReadDto();
            seatDto.seatNumber = this.seatNumber;
            seatDto.id = this.id;
            seatDto.status = this.status;
            seatDto.showId=this.showId;
            seatDto.showTitle=this.showTitle;
            seatDto.showDateTime=this.showDateTime;
            return seatDto;
        }
    }
}