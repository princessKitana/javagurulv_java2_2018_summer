package lv.javaguru.java2.services;

import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.database.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PrintProductService {
    @Autowired
    private Database database;

    public List<Product> getAllProducts(){
        return database.getAllProducts();
    }

}
