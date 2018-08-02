package lv.javaguru.java2.validator;

import lv.javaguru.java2.dto.Error;

import java.util.List;

public interface ProductValidator {

    List<Error> validate(String title, String description);
}
