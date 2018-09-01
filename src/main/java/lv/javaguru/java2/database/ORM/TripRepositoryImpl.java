package lv.javaguru.java2.database.ORM;

import lv.javaguru.java2.database.TripRepository;
import lv.javaguru.java2.domain.Trip;
import lv.javaguru.java2.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TripRepositoryImpl extends ORMRepository implements TripRepository{

    @Override
    public List<Trip> getAllTrips(){
        return session()
                .createCriteria(Trip.class)
                .list();
    }

    @Override
    public void addTrip(Trip trip){
        session().save(trip);
    }

    @Override
    public boolean checkTripExist(Long id, String status){

        Trip trip = (Trip) session().createCriteria(Trip.class)
                .add(Restrictions.eq("id", id))
                .add(Restrictions.eq("status", status))
                .uniqueResult();
        return trip.getId() != null;



    }
}
