package lv.javaguru.java2.integrationTests;

import lv.javaguru.java2.buisnesslogic.TripStatus;
import lv.javaguru.java2.config.SpringAppConfig;
import lv.javaguru.java2.database.Database;
import lv.javaguru.java2.domain.Trip;
import lv.javaguru.java2.domain.TripPassanger;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.Vehicle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.sql.Time;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringAppConfig.class })
public class DatabaseIntegrationTest {

    @Autowired
    private Database database;


//    @Test
//    public void getAllProducts() {
//        List<Product> all1 = database.getAllProducts();
//
//        Product product = new Product();
//        product.setTitle("p");
//        product.setDescription("d");
//        long time = System.currentTimeMillis();
//        product.setDate_added(new Date(time));
//        database.addProduct(product);
//
//        List<Product> all2 = database.getAllProducts();
//
//        assertEquals(all2.size() - all1.size(), 1);
//    }
    @Test
    public void registerUser() {

        User user = new User();
        user.setFirstName("Vasja");
        user.setLastName("Pupkin");
        user.setLogin("test");
        user.setPassword("test");
        user.setPhone("+37127130976");
        user.setEmail("vasja@pupkin.com");
        user.setDriver(false);

        database.registerUser(user);

    }

    @Test
    public void addTrip() {

        User user = new User();
        user.setId((long) 1);

        Trip trip = new Trip();
        trip.setOrigin("Riga");
        trip.setDestination("Liepaja");
        trip.setDate(Date.valueOf("2018-07-06"));
        trip.setTime(Time.valueOf("14:00:00"));
        trip.setUser(user);
        trip.setComment("will pick up at Alfa");
        trip.setPrice(Double.parseDouble("2.56"));
        trip.setPassangerCount(2);
        trip.setStatus(TripStatus.PENDING);
        database.addTrip(trip);

    }

    @Test
    public void addVehicle() {

        User user = new User();
        user.setId((long) 1);

        Vehicle car = new Vehicle();
        car.setUser(user);
        car.setColor("Black");
        car.setModel("Audi A4");
        car.setYear(2015);
        car.setRegNumber("LR-5789");

        database.addVehicle(car);

    }

    @Test
    public void addTripPassangers() {

        Trip trip = new Trip();
        trip.setId((long) 2);

        User passanger = new User();
        passanger.setId((long) 2);

        TripPassanger tripPassanger = new TripPassanger();
        tripPassanger.setTrip(trip);
        tripPassanger.setUser(passanger);

        database.addTripPassanger(tripPassanger);

    }

}
