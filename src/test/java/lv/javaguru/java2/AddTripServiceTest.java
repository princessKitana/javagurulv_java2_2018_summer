package lv.javaguru.java2;

import lv.javaguru.java2.DTO.AddProductResponse;
import lv.javaguru.java2.DTO.Error;
import lv.javaguru.java2.Validator.ProductValidator;
import lv.javaguru.java2.database.Database;
import lv.javaguru.java2.services.AddProductService;
import lv.javaguru.java2.services.AddTripService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertFalse;

public class AddTripServiceTest {

    private Database database;
    private AddTripService service;

    @Before
    public void init() {

        database = Mockito.mock(Database.class);

    }



}
