package lv.javaguru.java2.DBintegrationTests;

import lv.javaguru.java2.buisnesslogic.TripStatus;
import lv.javaguru.java2.config.SpringAppConfig;
import lv.javaguru.java2.database.TripPassangerRepository;
import lv.javaguru.java2.database.TripRepository;
import lv.javaguru.java2.database.UserRepository;
import lv.javaguru.java2.database.VehicleRepository;
import lv.javaguru.java2.domain.Trip;
import lv.javaguru.java2.domain.TripPassanger;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.Vehicle;
import lv.javaguru.java2.web.config.SpringWebMVCConfig;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;
import java.util.Optional;
import java.util.Random;



@FixMethodOrder
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class, classes = {SpringAppConfig.class })
@WebAppConfiguration
@Transactional
public class DatabaseIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private TripPassangerRepository tripPassangerRepository;


    @Test
    public void t1_registerDriver() {
        User driver = new User();
        driver.setFirstName("Vasja");
        driver.setLastName("Pupkin");
        driver.setLogin(generateRandomString( 5 ));
        driver.setPassword("test");
        driver.setPhone("+37127130976");
        driver.setEmail("vasja@pupkin.com");
        driver.setDriver(true);

        userRepository.registerUser( driver );

       // Optional<User> user = userRepository.getUserByLogin( driver.getLogin() );
        //driver.setId( user.get().getId() );
    }


    @Test
    public void t2_addVehicle() {
        User driver = new User();
        driver.setId( (long) 31);
        Vehicle car = new Vehicle();
        car.setUser(driver);
        car.setColor("Black");
        car.setModel("Audi A4");
        car.setYear("2015");
        car.setRegNumber("LR-5789");

        vehicleRepository.addVehicle(car);

    }

    @Test
    public void t3_addTrip() {

        User user = new User();
        user.setId((long) 33);

        Vehicle car = new Vehicle();
        car.setId((long) 19);

        Trip trip = new Trip();
        trip.setOrigin("Riga");
        trip.setDestination("Liepaja");
        trip.setDate(Date.valueOf(  "2018-07-06"));
        trip.setTime(Time.valueOf("14:00:00"));
        trip.setComment("will pick up at Alfa");
        trip.setPrice(Double.parseDouble("2.56"));
        trip.setPassangerCount(2);
        trip.setStatus(TripStatus.PENDING);
        trip.setUser(user);
        trip.setCar(car);

        tripRepository.addTrip(trip);

    }

    @Test
    public void t4_registerPassanger() {

        User user = new User();
        user.setFirstName("Petja");
        user.setLastName("Pervij");
        user.setLogin("test");
        user.setPassword("test");
        user.setPhone("+37127130976");
        user.setEmail("petja@pervij.com");
        user.setDriver(false);

        userRepository.registerUser(user);

    }

    @Test
    public void t5_addTripPassangers() {

        Trip trip = new Trip();
        trip.setId((long) 37);

        User passanger = new User();
        passanger.setId((long) 31);

        TripPassanger tripPassanger = new TripPassanger();
        tripPassanger.setTrip(trip);
        tripPassanger.setUser(passanger);

        tripPassangerRepository.addTripPassanger(tripPassanger);

    }


    private String generateRandomString(int bound) {
        Random random = new Random();
        return String.valueOf( random.nextInt(bound)  );
    }

}
