package lv.javaguru.java2.acceptancetests.addTripControllerTests;

import lv.javaguru.java2.acceptancetests.addTripControllerTests.AddTripControllerActions;
import lv.javaguru.java2.web.dtos.TripDTO;
import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class AddTripControllerAcceptanceTest {

    private AddTripControllerActions actions = new AddTripControllerActions();

    @Test
    public void addTrip() {
        TripDTO req = actions.createTrip();
        TripDTO resp = actions.addTrip(req);
        assertTrue(resp.getId() != null);

    }


    @Test
    public void getTrip() {
        TripDTO req = actions.createTrip();
        TripDTO resp = actions.addTrip(req);

        TripDTO trip = actions.getTrip(resp.getId());
        Assert.assertEquals(resp.getId(), trip.getId());
    }

    //TODO validation test

}
