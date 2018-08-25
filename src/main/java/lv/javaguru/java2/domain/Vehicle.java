package lv.javaguru.java2.domain;

import javax.persistence.*;

@Entity
@Table(name="vehicles")
public class Vehicle {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "driverId", nullable = false )
    private User user;

    @Column(name="model", nullable = false, length = 200)
    private String model;

    @Column(name="color", nullable = false, length = 200)
    private String color;

    @Column(name="year")
    private int year;

    @Column(name="regNumber", nullable = false, length = 200)
    private String regNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
