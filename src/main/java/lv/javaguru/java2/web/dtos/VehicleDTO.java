package lv.javaguru.java2.web.dtos;

public class VehicleDTO {

    private Long id;
    private Long driverId;
    private String model;
    private String color;
    private String year;
    private String regNumber;

    public VehicleDTO() {

    }

    public VehicleDTO(Long id, Long driverId, String model, String color, String year, String regNumber) {
        this.id = id;
        this.driverId = driverId;
        this.model = model;
        this.color = color;
        this.year = year;
        this.regNumber = regNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }
}
