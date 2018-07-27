package lv.javaguru.java2.Validator;

import lv.javaguru.java2.DTO.Error;

import java.util.List;

public interface ProductValidator {

    List<Error> validate(String title, String description);
}
