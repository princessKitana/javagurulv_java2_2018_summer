package lv.javaguru.java2.domain.lamda;

import lv.javaguru.java2.domain.Trip;

public interface SearchCriteria {

    boolean match(Trip p);

}
