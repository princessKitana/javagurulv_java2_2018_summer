package lv.javaguru.java2.domain.lamda;

import lv.javaguru.java2.domain.Trip;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class LamdaTest {

    public static void main(String[] args) {

        SearchCriteria author1 = new TitleSearchCriteria();

        SearchCriteria author2 = new SearchCriteria() {
            @Override
            public boolean match(Trip p) {
                return p.getDestination().equals("Liepaja");
            }
        };

        SearchCriteria author3 = p -> p.getDestination().equals("Milk");
        SearchCriteria author4 = p -> p.getDestination().equals("Beer");

        List<Trip> products = new ArrayList<>();
        search1(products, author1);
        search1(products, author3);
        search1(products, author4);

    }

    private static List<Trip> search1(List<Trip> products,
                                         SearchCriteria searchCriteria) {
        List<Trip> found = new ArrayList<>();
        for (Trip p : products) {
            if (searchCriteria.match(p)) {
                found.add(p);
            }
        }
        return found;
    }

    private static List<Trip> search2(List<Trip> products,
                                         SearchCriteria searchCriteria) {
        return products.stream()
                .filter(p -> searchCriteria.match(p))
                .collect(toList());
    }

}
