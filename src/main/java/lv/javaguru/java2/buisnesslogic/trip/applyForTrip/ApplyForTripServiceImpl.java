package lv.javaguru.java2.buisnesslogic.trip.applyForTrip;

import lv.javaguru.java2.buisnesslogic.ApplicationError;
import lv.javaguru.java2.buisnesslogic.ApplicationException;
import lv.javaguru.java2.database.TripPassangerRepository;
import lv.javaguru.java2.database.TripRepository;
import lv.javaguru.java2.domain.TripPassanger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ApplyForTripServiceImpl implements ApplyForTripService{

    @Autowired
    private TripPassangerRepository tripPassangerRepository;

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private ApplyForTripValidator validator;

    @Transactional
    @Override
    public ApplyForTripResponse applyForTrip(ApplyForTripRequest request){

        List<ApplicationError> validationApplicationErrors = validator.validate(request);

        if (!validationApplicationErrors.isEmpty()) {
            throw new ApplicationException(validationApplicationErrors);
        }

        tripRepository.pssangerCountLessOne(request.getTrip().getId());

        TripPassanger tripPassanger = new TripPassanger();
        tripPassanger.setUser(request.getPassanger());
        tripPassanger.setTrip(request.getTrip());

        tripPassangerRepository.addTripPassanger(tripPassanger);

        return new ApplyForTripResponse(tripPassanger.getId());
    }
}
