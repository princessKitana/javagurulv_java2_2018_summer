package lv.javaguru.java2.IntegrationTests;

import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.domain.Trip;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.database.Database;
import lv.javaguru.java2.database.JDBCDatabaseImpl;
import org.junit.Test;

import java.sql.Date;
import java.time.LocalTime;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DatabaseIntegrationTest {

    private Database database = new JDBCDatabaseImpl();

    @Test
    public void AddProduct() {
        Product product = new Product();
        product.setTitle("p");
        product.setDescription("d");
        long time = System.currentTimeMillis();
        product.setDate_added(new Date(time));
        database.addProduct(product);
    }

    @Test
    public void getAllProducts() {
        List<Product> all1 = database.getAllProducts();

        Product product = new Product();
        product.setTitle("p");
        product.setDescription("d");
        long time = System.currentTimeMillis();
        product.setDate_added(new Date(time));
        database.addProduct(product);

        List<Product> all2 = database.getAllProducts();

        assertEquals(all2.size() - all1.size(), 1);
    }

    @Test
    public void addTrip() {

        Trip trip = new Trip();
        trip.setOrigin("Riga");
        trip.setDestination("Liepaja");
        long time = System.currentTimeMillis();
        LocalTime time1 = LocalTime.of(22, 15);
        trip.setDate(new Date(time));
        trip.setTime(time1);
        trip.setDriverId((long) 1123);
        trip.setComment("will pick up at Alfa");
        trip.setPrice(2.56);
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
        user.setLogin("test");
        user.setPhone("+37127130976");
        user.setEmail("vasja@pupkin.com");
        user.setDriver(false);

        database.registerUser(user);

    }
}
