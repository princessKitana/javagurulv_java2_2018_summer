package lv.javaguru.java2.buisnesslogic.applyForTrip;

import lv.javaguru.java2.Error;
import lv.javaguru.java2.database.TripPassangerRepository;
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
    private ApplyForTripValidator validator;

    @Transactional
    @Override
    public ApplyForTripResponse applyForTrip(ApplyForTripRequest request){

        List<Error> validationErrors = validator.validate(request);

        if (!validationErrors.isEmpty()) {
            return new ApplyForTripResponse(validationErrors);
        }

        TripPassanger tripPassanger = new TripPassanger();
        tripPassanger.setUser(request.getPassanger());
        tripPassanger.setTrip(request.getTrip());

        tripPassangerRepository.addTripPassanger(tripPassanger);

        return new ApplyForTripResponse(tripPassanger.getId());
    }
}
