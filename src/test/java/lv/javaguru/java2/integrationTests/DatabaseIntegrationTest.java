package lv.javaguru.java2.integrationTests;

import lv.javaguru.java2.domain.Trip;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.database.Database;
import lv.javaguru.java2.database.JDBCDatabaseImpl;
import org.junit.Test;

import java.sql.Date;
import java.sql.Time;

import static org.junit.Assert.assertEquals;

public class DatabaseIntegrationTest {

    private Database database = new JDBCDatabaseImpl();


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
    public void addTrip() {

        Trip trip = new Trip();
        trip.setOrigin("Riga");
        trip.setDestination("Liepaja");
        trip.setDate(Date.valueOf("2018-07-06"));
        trip.setTime(Time.valueOf("14:00:00"));
        trip.setDriverId((long) 1);
        trip.setComment("will pick up at Alfa");
        trip.setPrice(Double.parseDouble("2.56"));
        trip.setStatus("PENDING");
        database.addTrip(trip);

    }

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
}
