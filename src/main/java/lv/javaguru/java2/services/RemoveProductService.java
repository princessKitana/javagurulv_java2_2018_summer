//package lv.javaguru.java2.services;
//
//import lv.javaguru.java2.database.Database;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.Optional;
//
//@Component
//public class RemoveProductService {
//
//    @Autowired
//    private Database database;
//
//    public boolean removeProductByTitle(String title) {
//        Optional<Product> foundProduct = database.getByTitle(title);
//        if (foundProduct.isPresent()) {
//            Product product = foundProduct.get();
//            boolean isRemoved = database.remove(product);
//            return isRemoved;
//        } else {
//            return false;
//        }
//    }
//}
