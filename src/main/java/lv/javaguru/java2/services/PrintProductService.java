package lv.javaguru.java2.services;

import lv.javaguru.java2.Product;
import lv.javaguru.java2.database.Database;

import java.util.List;

public class PrintProductService {

    private Database database;

    public void PrintProductService(Database database) {
        this.database = database;
    }

    public List<Product> getAllProducts(){
        return database.getAllProducts();
    }

}
