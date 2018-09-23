package lv.javaguru.java2.database.ORM;

import lv.javaguru.java2.buisnesslogic.TripStatus;
import lv.javaguru.java2.database.TripRepository;
import lv.javaguru.java2.domain.Trip;
import lv.javaguru.java2.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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
    public boolean checkTripExist(Long id, TripStatus status){

        Trip trip = (Trip) session().createCriteria(Trip.class)
                .add(Restrictions.eq("id", id))
                .add(Restrictions.eq("status", status))
                .uniqueResult();

        if (trip != null) {
            return true;
        } else return false;
    }

    @Override
    public Optional<Trip> getTripById(Long id){
        Trip trip = (Trip) session().createCriteria(Trip.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();

        return Optional.ofNullable(trip);
    }

    @Override
    public void pssangerCountLessOne(Long id){
        Trip trip = (Trip) session().createCriteria(Trip.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
        int count = trip.getPassangerCount();
        count = count - 1;

        Trip updatedTrip = (Trip) session().get(Trip.class, trip.getId());
        updatedTrip.setPassangerCount(count);

        if (count<=0) updatedTrip.setStatus( TripStatus.FULL );

        session().update(updatedTrip);
    }


}
