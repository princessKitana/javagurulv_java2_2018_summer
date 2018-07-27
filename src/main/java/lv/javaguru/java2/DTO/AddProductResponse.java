package lv.javaguru.java2.DTO;

import lv.javaguru.java2.DTO.Error;

import java.util.List;

public class AddProductResponse {

    private boolean success;
    private Integer productId;
    private List<Error> errors;

    public Integer getProductId() {
        return productId;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public boolean isSussess() {
        return success;
    }

    public AddProductResponse(Integer productId) {
        this.success = true;
        this.productId = productId;
    }

    public AddProductResponse(List<Error> errors) {
        this.success = false;
        this.errors = errors;
    }
}
