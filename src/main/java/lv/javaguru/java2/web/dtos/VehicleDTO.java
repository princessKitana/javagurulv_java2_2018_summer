package lv.javaguru.java2.web.dtos;

public class VehicleDTO {

    private Long id;
    private Long userId;
    private String model;
    private String color;
    private Integer year;
    private String regNumber;

    public VehicleDTO() {

    }

    public VehicleDTO(Long id, Long userId, String model, String color, int year, String regNumber) {
        this.id = id;
        this.userId = userId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }
}
