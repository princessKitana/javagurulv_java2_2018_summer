package lv.javaguru.java2.domain.lamda;

import lv.javaguru.java2.domain.Trip;

public class TitleSearchCriteria implements SearchCriteria {
    @Override
    public boolean match(Trip p) {
        return p.getDestination().equals("Liepaja");
    }
}
