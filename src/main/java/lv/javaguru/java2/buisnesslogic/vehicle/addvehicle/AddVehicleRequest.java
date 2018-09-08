package lv.javaguru.java2.buisnesslogic.vehicle.addvehicle;

import lv.javaguru.java2.domain.Vehicle;

public class AddVehicleRequest {

    private Long driverId;
    private String model;
    private String color;
    private int year;
    private String regNumber;

    public AddVehicleRequest(Vehicle car) {
        this.driverId = car.getUser().getId();
        this.model = car.getModel();
        this.color = car.getColor();
        this.year = car.getYear();
        this.regNumber = car.getRegNumber();
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }
}
