package cinema.CinemaManagementApp.controller.dto;

import cinema.CinemaManagementApp.controller.ShowController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.List;

public class ReservationDto {



    private int id;
    private String customerName;
    private String customerPhone;
    List<SeatReadDto> seats;
    private static final Logger logger = LoggerFactory.getLogger(ShowController.class);


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public List<SeatReadDto> getSeats() {
        return seats;
    }

    public void sets(List<SeatReadDto> seats) {
        this.seats = seats;
    }

    public static Logger getLogger() {
        return logger;
    }



    public static final class ReservationDtoBuilder {
        private int id;
        private String customerName;
        private String customerPhone;
        List<SeatReadDto> seats;


        public ReservationDtoBuilder() {
        }

        public static ReservationDto.ReservationDtoBuilder aReservationDto() {
            return new ReservationDto.ReservationDtoBuilder();
        }

        public ReservationDto.ReservationDtoBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public ReservationDto.ReservationDtoBuilder withCustomerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public ReservationDto.ReservationDtoBuilder withCustomerPhone(String customerPhone) {
            this.customerPhone = customerPhone;
            return this;
        }


        public ReservationDto.ReservationDtoBuilder withSeatReadDto(List<SeatReadDto> seats) {
            this.seats = seats;
            return this;
        }






        public ReservationDto build() {
            ReservationDto ReservationDto = new ReservationDto();
            ReservationDto.id = this.id;
            ReservationDto.customerName = this.customerName;
            ReservationDto.customerPhone = this.customerPhone;
            ReservationDto.seats = this.seats;
            return ReservationDto;
        }
    }




}

