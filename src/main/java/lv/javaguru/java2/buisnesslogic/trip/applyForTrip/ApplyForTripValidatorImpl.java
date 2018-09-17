package lv.javaguru.java2.buisnesslogic.trip.applyForTrip;

import lv.javaguru.java2.buisnesslogic.ApplicationError;
import lv.javaguru.java2.buisnesslogic.TripStatus;
import lv.javaguru.java2.database.TripRepository;
import lv.javaguru.java2.database.UserRepository;
import lv.javaguru.java2.domain.User;
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
    public List<ApplicationError> validate(ApplyForTripRequest request){

        List<ApplicationError> applicationErrors = new ArrayList<>();

        checkUserExist(request.getPassanger().getId()).ifPresent(applicationErrors::add);
        checkPendingTripExist(request.getTrip().getId()).ifPresent(applicationErrors::add);
        //TODO check passanger alreay apllied?
        //TODO check passanger apllied is not trip driver
        //TODO check passanger seats availiable
        //TODO check trip is pending

            return applicationErrors;
        }

        private Optional<ApplicationError> checkUserExist(Long userId) {

            if (userId == null) {
                return Optional.of(new ApplicationError("userId", "Cannot be empty"));
            } else {
                Optional<User> user = userRepository.checkUserExist(userId);
                if (user.isPresent()) {
                    return Optional.empty();
                } else
                    return Optional.of(new ApplicationError("userId", "Does not exist"));
            }
        }

    private Optional<ApplicationError> checkPendingTripExist(Long tripId) {

        if (tripId == null) {
            return Optional.of(new ApplicationError("tripId", "Cannot be empty"));
        } else {
            if (tripRepository.checkTripExist(tripId, TripStatus.PENDING)) {
                return Optional.empty();
            } else
                return Optional.of(new ApplicationError("tripId", "Does not exist"));
        }


    }


}

