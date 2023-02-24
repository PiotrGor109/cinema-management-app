package cinema.CinemaManagementApp.controller.dto;


public class CinemaHallDto {

    private int id;
    private int numberOfPlaces;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public void setNumberOfPlaces(int numberOfPlaces) {
        this.numberOfPlaces = numberOfPlaces;
    }



    public static final class CinemaHallDtoBuilder {
        private int id;
        private int numberOfPlaces;



        public CinemaHallDtoBuilder() {
        }

        public static CinemaHallDto.CinemaHallDtoBuilder aCinemaHallDto() {
            return new CinemaHallDto.CinemaHallDtoBuilder();
        }

        public CinemaHallDto.CinemaHallDtoBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public CinemaHallDto.CinemaHallDtoBuilder withNumberOfPlaces(int numberOfPlaces) {
            this.numberOfPlaces = numberOfPlaces;
            return this;
        }


        public CinemaHallDto build() {
            CinemaHallDto CinemaHallDto = new CinemaHallDto();
            CinemaHallDto.numberOfPlaces = this.numberOfPlaces;
            CinemaHallDto.id=this.id;
            return CinemaHallDto;
        }
    }
}

