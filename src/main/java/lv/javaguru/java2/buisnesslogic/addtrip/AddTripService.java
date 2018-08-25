package lv.javaguru.java2.buisnesslogic.addtrip;

import org.springframework.stereotype.Component;

@Component
public interface AddTripService {

    AddTripResponse addTrip(AddTripRequest request);
}
