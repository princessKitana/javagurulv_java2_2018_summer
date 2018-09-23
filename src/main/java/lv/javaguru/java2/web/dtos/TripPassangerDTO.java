package lv.javaguru.java2.web.dtos;



public class TripPassangerDTO {

    private Long id;

    private Long trip;
    private Long passanger;

    public TripPassangerDTO() {
    }

    public TripPassangerDTO(Long id, Long trip, Long passanger) {
        this.id = id;
        this.trip = trip;
        this.passanger = passanger;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTrip() {
        return trip;
    }

    public void setTrip(Long trip) {
        this.trip = trip;
    }

    public Long getPassanger() {
        return passanger;
    }

    public void setPassanger(Long passanger) {
        this.passanger = passanger;
    }
}
