package lv.javaguru.java2.buisnesslogic.applyForTrip;

import lv.javaguru.java2.Error;
import lv.javaguru.java2.buisnesslogic.TripStatus;
import lv.javaguru.java2.database.TripRepository;
import lv.javaguru.java2.database.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ApplyForTripValidatorImpl implements ApplyForTripValidator {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TripRepository tripRepository;

    @Override
    public List<Error> validate(ApplyForTripRequest request){

            List<Error> errors = new ArrayList<>();

            checkUserExist(request.getPassanger().getId()).ifPresent(errors::add);
            checkPendingTripExist(request.getTrip().getId()).ifPresent(errors::add);
            //TODO check user alreay apllied?

            return errors;
        }

        private Optional<Error> checkUserExist(Long userId) {

            if (userId == null) {
                return Optional.of(new Error("userId", "Cannot be empty"));
            } else {
                if (userRepository.checkUserExist(userId)) {
                    return Optional.empty();
                } else
                    return Optional.of(new Error("userId", "Does not exist"));
            }
        }

    private Optional<Error> checkPendingTripExist(Long tripId) {

        if (tripId == null) {
            return Optional.of(new Error("tripId", "Cannot be empty"));
        } else {
            if (tripRepository.checkTripExist(tripId, String.valueOf(TripStatus.PENDING))) {
                return Optional.empty();
            } else
                return Optional.of(new Error("tripId", "Does not exist"));
        }


    }


}

