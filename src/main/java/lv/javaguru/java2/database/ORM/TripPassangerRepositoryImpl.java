package lv.javaguru.java2.database.ORM;

import lv.javaguru.java2.database.TripPassangerRepository;
import lv.javaguru.java2.domain.Trip;
import lv.javaguru.java2.domain.TripPassanger;
import lv.javaguru.java2.domain.User;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TripPassangerRepositoryImpl extends ORMRepository implements TripPassangerRepository {

    public void addTripPassanger(TripPassanger tripPassanger){
        session().save(tripPassanger);
    }

    @Override
    public Optional<TripPassanger> checkPassangerAppliedForTrip(Long passengerId, Long tripId){

        User user = new User();
        user.setId( passengerId );

        Trip trip = new Trip();
        trip.setId(tripId);

        TripPassanger tripPassanger = (TripPassanger) session().createCriteria(TripPassanger.class)
                .add( Restrictions.eq("passanger", user))
                .add( Restrictions.eq("trip", trip))
                .uniqueResult();

        return Optional.ofNullable(tripPassanger);
    }

}
