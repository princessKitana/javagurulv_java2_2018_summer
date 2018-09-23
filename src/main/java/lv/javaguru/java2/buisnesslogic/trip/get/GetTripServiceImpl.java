package lv.javaguru.java2.buisnesslogic.trip.get;

import lv.javaguru.java2.buisnesslogic.ApplicationError;
import lv.javaguru.java2.buisnesslogic.ApplicationException;
import lv.javaguru.java2.buisnesslogic.user.get.GetUserRequest;
import lv.javaguru.java2.buisnesslogic.user.get.GetUserResponse;
import lv.javaguru.java2.buisnesslogic.user.get.GetUserService;
import lv.javaguru.java2.database.TripRepository;
import lv.javaguru.java2.domain.Trip;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.web.dtos.TripDTO;
import lv.javaguru.java2.web.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class GetTripServiceImpl implements GetTripService {

        @Autowired
        private TripRepository database;

    @Override
    @Transactional
        public GetAllTripsResponse getAllTrips(){

        List<Trip> trips1 = database.getAllTrips();
        List<TripDTO> trips2 = new ArrayList<>(  );

        trips1.forEach((temp) -> {
            TripDTO tripDTO = new TripDTO(temp);
            trips2.add(tripDTO);
        });

            return new GetAllTripsResponse(trips2);
        }

        @Override
        @Transactional
        public GetTripResponse get(GetTripRequest request){
                Optional<Trip> tripOptional = database.getTripById(request.getTripId());
                if (tripOptional.isPresent()) {
                    Trip trip = tripOptional.get();

                   TripDTO tripDTO = new TripDTO(trip);

                    return new GetTripResponse(tripDTO);
                } else {
                    ApplicationError error = new ApplicationError("id", "Not found");
                    throw new ApplicationException(error);
                }
            }

    }

